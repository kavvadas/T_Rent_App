# ΠΧ6. Διαχείριση Αγαπημένων

**Πρωτεύων Actor**: Ενοικιαστής

**Ενδιαφερόμενοι**

**Ενοικιαστής**: Ενδιαφέρεται να αποθηκεύσει μια κατοικία που ίσως τον ενδιαφέρει μελλοντικά(ή να την αφαιρέσει)

**Προϋπόθεσεις**: Ο ενοικιαστής βρίσκεται στους χάρτες

*Βασική Ροή*

### Α) Προσθήκη στα αγαπημένα
1) [Προβολή πληροφοριών κατοικίας](uc4-view-info.md)
2) Το σύστημα εμφανίζει επιλογη "Προσθήκη στα αγαπημένα"
3) Ο ενοικιαστής επιλέγει την προσθήκη.
4) Το σύστημα ελέγχει την λίστα αγαπημένων.
5) Το σύστημα ενημερώνει τη λίστα αγαπημένων.

**Εναλλακτική Ροή**
*4α. Η κατοικία υπάρχει ήδη στη λίστα αγαπημένων.*
1) Το σύστημα εμφανίζει την επιλογή αφαίρεσης απο τη λίστα.
2) Ο χρήστης επιλέγει να αφαιρέσει ή οχι την κατοικία.
3) Το σύστημα ενημερώνει τη λίστα αγαπημένων.
4) Επιστρέφουμε στο βήμα 1.

### Β) Αφαίρεση απο τα αγαπημένα
1) Ο χρήστης επιλέγει την επεξεργασία αγαπημένων.
2) Το σύστημα εμφανίζει όλες τις αποθηκευμένες κατοικίες.
    * 2α. Δεν υπάρχουν αποθηκευμένες κατοικίες.
    1) Το σύστημα εμφανίζει κατάλληλο μήνυμα.
    2) Επιστρέφουμε στο βήμα 1.
3) ο χρήστης επιλέγει την αφαίρεση μιας(ή περισσότερων) κατοικίας.
4) Το σύστημα ενημερώνει την λίστα των αγαπημένων.



