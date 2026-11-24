<span style="color: red;"><strong>Bitte keine privaten oder unternehmensbezogenen Informationen ergänzen.</strong></span>

# Spring Boot Test- und Schulungsprojekt

Dieses Projekt dient zum Testen und Üben mit Spring Boot, MVC, REST-APIs und Liquibase. Die Funktionen und Aufgaben sind auf mehrere Branches verteilt.

## Branches

### `main` – MVC mit Oberfläche

- Anwendung: `http://localhost:8080`
- Enthält eine einfache MVC-Oberfläche.
- **Aufgabe:** Gib „Hello Mr XYZ“ aus und wandle den Text in Großbuchstaben um.

### `liquibase` – Datenbank und Schemaänderungen

- Datenbank: H2
- H2-Konsole: `http://localhost:8080/h2-console`
- Zugangsdaten: leer lassen
- **Aufgabe:** Füge eine weitere Spalte für die Telefonnummer hinzu. Setze die Änderung mit Liquibase um.

### `restapi` – REST-API mit Swagger UI

- Swagger UI: `http://localhost:8080/swagger-ui/index.html`
- **Aufgabe:** Ergänze eine neue CRUD-Operation für Telefonnummern und speichere die Telefonnummern in der Datenbank.

## Branch wechseln

```bash
git switch main
```

Ersetze `main` durch `liquibase` oder `restapi`, um den jeweiligen Projektstand aufzurufen.

## Beim ersten Start in Eclipse

1. Den richtigen Branch auschecken.
2. Rechtsklick auf das Projekt und **Maven → Update Project** auswählen.
3. Rechtsklick auf das Projekt und **Run As → Maven Build...** auswählen. Unter **Goals** `clean install` eintragen und den Build starten.
4. Anwendung im **Debug-Modus** starten.
