## Wprowadzenie

Otrzymałeś zlecenie na napisanie systemu wyszukiwania połączeń pomiędzy miastami od nowego przewoźnika kolejowego z Podlasia. System musi wyszukać najkrótszą drogę pomiędzy dwoma miastami. Zleceniodawcy zależy, aby wyszukiwanie było jak najszybsze.

# Zadanie
1. Napisz testy akceptacyjne zgodne z podaną dokumentacją,
2. Napisz aplikację wystawiającą JSON API zgodnie z dokumentacją,
3. Aplikacja może zostać stworzona z użyciem dowolnej technologii,
4. Użyj Gita do udokumentowania historii projektu,
5. Logowanie nie jest wymagane

# Dokumentacja

## Add train
Endpoint do dodawania połączenia kolejowego. Dodanie połączenia Wrocław -> Warszawa **nie** oznacza, że istnieje połączenie Warszawa -> Wrocław. 

**HTTP REQUEST**
    POST http://example.com/api/trains
**JSON Payload:**

    {
      "train": ["Poznań", "Wadowice"]
    }

**Walidacje:**
- Trasa jest unikalna - nie można dodać dwa razy tej samej,
- Nie można dodać trasy A->A.
W każdym scenariuszu serwer powinien zwrócić odpowiedni status HTTP. 

------------
## Find shortest route
Endpoint do wyszukiwania najkrótszej trasy pomiędzy dwoma miastami. Zwraca wiele tras jeśli mają tę samą długość.

**HTTP REQUEST** 
    GET http://example.com/api/shortest_route?start=START&destination=DESTINATION

**Request params:**

    {
      "start": "Poznań",
      "destination": "Wadowice"
    }

**JSON Response:**

    {
      "routes": [
        [
          "Poznań",
          "Wrocław",
          "Wadowice"
        ],
        [
          "Poznań",
          "Łódź",
          "Wadowice"
        ]
      ],
      "distance": 2
    }
------------
## Dodatkowe punkty za:
- jak najlepiej zoptymalizowany algorytm (szybkość i potrzebne zasoby),
- implementację systemu cachingu (dla ułatwienia cache kasowany przy dodaniu pociągu)
- użycie bazy danych innej niż relacyjna


