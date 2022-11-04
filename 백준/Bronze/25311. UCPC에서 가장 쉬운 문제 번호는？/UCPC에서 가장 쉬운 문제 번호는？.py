def get_Answer(year):
    number = "A"
    if year == 2018 or year == 2019 or year == 2020 or year == 2021 or year == 2022:
        number = "A"
    return number


if __name__ == "__main__":
    year = int(input())
    print(get_Answer(year=year))