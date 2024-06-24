import csv
import sqlite3

def pmd_to_csv(pmd_report_file:str, csv_file_name:str)->None:
    """
    This function transforms a text-based PMD report into a CSV format.
    Each line in the input file will be transformed and stored in the output file. 
    input:
        path/to/file/filename.java:line_number:finding_name:finding_description
    output:
        "finding_name","finding_description","path/to/file/filename.java",line_number
    """
    with open(pmd_report_file, 'r', encoding="utf-8") as input_file, \
        open(csv_file_name, 'w', encoding="utf-8") as output_file:
        output_file.write("name,description,file,line\n")
        for line in input_file:
            # print(line) TODO: Regex check - warning
            line = line.strip()
            first_colon_index = line.index(':')
            second_colon_index = line.index(':', first_colon_index + 1)
            third_colon_index = line.index(':', second_colon_index + 1)

            file_string = line[:first_colon_index]
            line_number = line[first_colon_index + 1:second_colon_index]
            finding_name = line[second_colon_index + 1:third_colon_index]
            finding_description = line[third_colon_index + 1:]
            output_line = '"' + finding_name.strip() + \
                '","' + finding_description.strip().replace('"', "'") + \
                '","' + file_string.strip() + '",' + line_number + '\n'
            output_file.write(output_line)


def sort_file(file_name:str)->None:
    """
    This function simply sorts the lines of a given text file.
    """
    with open(file_name, 'r', encoding="utf-8") as file:
        lines = file.readlines()
    lines.sort()
    with open(file_name, 'w', encoding="utf-8") as file:
        for line in lines:
            file.write(line)


def import_pmd_csv(file_name:str, db_name:str)->None:
    with open(file_name, 'r', encoding="utf-8") as file:
        reader = csv.reader(file)
        data = list(reader)

    conn = sqlite3.connect(db_name)
    c = conn.cursor()
    c.execute('''CREATE TABLE findings (name TEXT, description TEXT, file TEXT, line INTEGER)''')
    for row in data[1:]:  # skip the header row
        c.execute("INSERT INTO findings VALUES (?, ?, ?, ?)", row)
    conn.commit()
    conn.close()

if __name__ == '__main__':
    PMD_REPORT = "./reports/pmd-report.txt"
    CSV_FILE = "./reports/report.csv"
    DB_FILE = "./reports/report.db"
    # Transformation steps
    pmd_to_csv(PMD_REPORT, CSV_FILE)
    import_pmd_csv(CSV_FILE, DB_FILE)

# Analysis is done in SQL:
# SELECT name, description, file FROM findings ORDER BY name;
# SELECT DISTINCT name FROM findings ORDER BY name;
# SELECT name,description,line,file FROM findings ORDER BY file;

# SELECT * FROM findings WHERE file LIKE '%src/test%' ORDER BY name;
# SELECT * FROM findings WHERE file LIKE '%src/main%' ORDER BY name;
