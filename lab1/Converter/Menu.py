from Converter.CurrencyData import CurrencyData
from Converter.CurrencyConverter import CurrencyConverter
from Converter.DataOperations import DataOperations
import os


class Menu():
    def __init__(self):
        os.system("clear")
        self.choice = None
        self.currencyData = CurrencyData()
        self.converter = CurrencyConverter()
        self.dataOper = DataOperations("https://www.nbp.pl/kursy/xml/lasta.xml", "currencies")

    def show_menu(self):

        while self.choice != 6:
            print('----------------------MENU-------------------')
            print('1. Wyświetl kody dostępnych walut')
            print('2. Konwertuj')
            print('3. Wczytaj listę walut z sieci')
            print('4. Koniec\n')
            try:
                self.choice = int(input("Twój wybór: "))
                self.make_decision()
            except ValueError:
                os.system("cls")
                print("Nieprawidłowa opcja. Wybierz ponownie.")

    def make_decision(self):
        if self.choice == 1:
            os.system("clear")
            self.show_currencies()
        elif self.choice == 2:
            self.convert_currencies()

        elif self.choice == 3:
            os.system("clear")
            self.update_currencies()

        elif self.choice == 4:
            exit()
        else:
            os.system("clear")
            print("Nieprawidłowa opcja. Wybierz ponownie.")

    def show_currencies(self):
        show_names = str(input("Wyświetlać pełne nazwy walut? (tak/nie): "))
        if (show_names == "tak"):
            show_names = True
        elif (show_names == "nie"):
            show_names = False
        else:
            show_names = False
        self.currencyData.show_currencies(name=show_names, factor=False, code=True, exRate=False)

    def convert_currencies(self):
        sourceVal = float(input("Podaj wartość początkową [float]: "))
        sourceCode = str(input("Podaj kod waluty początkowej [str]: ")).upper()
        targetCode = str(input("Podaj kod waluty docelowej [str]: ")).upper()
        try:
            sourceCurrency = self.currencyData.get_currency_by_code(sourceCode)
            targetCurrency = self.currencyData.get_currency_by_code(targetCode)

            if sourceCurrency is None or targetCurrency is None:
                os.system("clear")
                print("Nieprawidłowe kody walut. Spróbuj ponownie.")
            else:
                convertedValue = self.converter.convert(sourceVal, sourceCurrency, targetCurrency)
                os.system("clear")
                print(f"{sourceVal} {sourceCode} = {convertedValue} {targetCode}")
        except ValueError as e:
            os.system("clear")
            print(f"Błąd konwersji: {e}")

    def update_currencies(self):
        self.dataOper.update_currencies(self.currencyData)

