import csv
import json
import ast

file = "flipkart.csv"
file2 = "prod.csv"
csv2 = open(file2, 'w', newline='', encoding="utf8")
csvwriter = csv.writer(csv2)

with open(file, 'r', encoding="utf8") as csvfile:
    csvreader = csv.reader(csvfile)
    i = 0
    for row in csvreader:
        #correcting brand
        rec = str(row[1])[2:-2].split(">>")
        if len(rec) == 1:
            row[1] = rec[0]
        else:
            row[1] = rec[-2:-1][0]

        #correcting images
        row[4] = "{\"images\":"+str(row[4])+"}"

        #correcting specification
        if len(str(row[9])) > 1:
            row[9] = str(row[9]).replace("=>", ":")
            if str(row[9]).find("[") != -1:
                row[9] = str(row[9]).replace("{\"key\":", "")
                row[9] = str(row[9]).replace("\"}", "\"")
            else:
                row[9] = str(row[9]).replace("\"key\":", "")
            row[9] = str(row[9]).replace("[", "{")
            row[9] = str(row[9]).replace("]", "}")
            row[9] = str(row[9]).replace(", \"value\"", "")
            row[9] = str(row[9]).replace("{\"value\"", "\"value\"")
            row[9] = str(row[9]).replace("\"nil\"", "null")

        flag = True
        for r in row:
            if len(str(r)) == 0:
                flag = False
        if flag:
            csvwriter.writerow(row)