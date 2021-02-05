import csv

file = "category.csv"
file2 = "cat.csv"
csv2 = open(file2, 'w', newline='')
csvwriter = csv.writer(csv2)

with open(file, 'r') as csvfile:
    csvreader = csv.reader(csvfile)
    for row in csvreader:
        rec = str(row[0])[2:-2].split(">>")
        if len(rec) == 1:
            csvwriter.writerow(rec)
        else:
            csvwriter.writerow(rec[:-1])
