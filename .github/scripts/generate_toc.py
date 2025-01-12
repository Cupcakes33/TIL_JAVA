import os
import re
import time
import subprocess

def find_md_files(src_dir):
    md_files = []
    for root, dirs, files in os.walk(src_dir):
        for file in files:
            if file.endswith('.md'):
                md_files.append(os.path.join(root, file))
    return md_files

def extract_section_and_headers(file_path):
    section_match = re.search(r'Section(\d+)', file_path)
    if not section_match:
        return None, [], None

    section_num = section_match.group(1)
    headers = []
    file_name = os.path.basename(file_path)

    try:
        with open(file_path, 'r', encoding='utf-8') as f:
            content = f.read()
            headers = re.findall(r'^#\s+(.+)$', content, re.MULTILINE)
    except Exception as e:
        return None, [], None

    return section_num, headers, file_name

def get_file_creation_date(file_path):
    try:
        repo_root = subprocess.check_output(
            ['git', 'rev-parse', '--show-toplevel'],
            text=True,
            stderr=subprocess.PIPE
        ).strip()

        abs_path = os.path.abspath(file_path)
        rel_path = os.path.relpath(abs_path, repo_root)
        git_path = rel_path.replace(os.sep, '/')

        first_commit = subprocess.check_output(
            [
                'git',
                'log',
                '--follow',
                '--reverse',
                '--format=%ad',
                '--date=format:%y/%m/%d %H:%M',
                '--',
                git_path
            ],
            text=True,
            cwd=repo_root,
            stderr=subprocess.PIPE
        ).strip()

        if first_commit:
            return first_commit.split('\n')[0]

        return time.strftime('%y/%m/%d %H:%M',
                             time.localtime(os.path.getmtime(file_path)))

    except subprocess.CalledProcessError as e:
        print(f"Git command error for {git_path}: {e.stderr.decode()}", flush=True)
        return time.strftime('%y/%m/%d %H:%M',
                             time.localtime(os.path.getmtime(file_path)))
    except Exception as e:
        print(f"Unexpected error for {file_path}: {str(e)}", flush=True)
        return time.strftime('%y/%m/%d %H:%M',
                             time.localtime(os.path.getmtime(file_path)))

def generate_toc():
    sections = {}
    md_files = find_md_files('src')

    for file in md_files:
        section_num, headers, file_name = extract_section_and_headers(file)
        if section_num:
            section_num = int(section_num)
            if section_num not in sections:
                sections[section_num] = []

            file_path = os.path.join('src', f'Section{section_num}', file_name)
            date = get_file_creation_date(file_path)

            for header in headers:
                entry = (header, file_name, date)
                if entry not in sections[section_num]:
                    sections[section_num].append(entry)

    toc = []
    toc.append("# JAVA 학습 기록 📚\n\n")
    toc.append("자바 기초부터 심화까지의 학습 내용을 정리합니다.\n")
    toc.append("김영한 선생님의 강의를 듣고 코드를 작성하고 내용을 요약합니다.\n\n")

    for section_num in sorted(sections.keys()):
        toc.append(f"## Section {section_num}\n")
        section_entries = sorted(sections[section_num], key=lambda x: x[2])
        for i, (header, file_name, date) in enumerate(section_entries, 1):
            file_path = f"src/Section{section_num}/{file_name}"
            toc.append(f"{i}. [{header}]({file_path}) - {date}\n")
        toc.append("\n")

    toc_content = ''.join(toc)

    try:
        with open('README.md', 'w', encoding='utf-8') as f:
            f.write(toc_content)
    except Exception:
        pass

if __name__ == '__main__':
    current_dir = os.path.dirname(os.path.abspath(__file__))
    project_root = os.path.abspath(os.path.join(current_dir, '..', '..'))
    os.chdir(project_root)
    generate_toc()