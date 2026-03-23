# 📋 Formulaire App — By SAAD

Application Android deux écrans : saisie d'un formulaire ➜ affichage d'un récapitulatif.


## 📽️ Démonstration

https://github.com/user-attachments/assets/e79e2cdc-3cd2-4a01-a10c-4727b9471c5d

## 🖼️ Interface — `res/layout/activity_main.xml`

### Champs de saisie — `EditText`

```xml
<EditText
    android:id="@+id/et_nom"
    android:hint="Nom complet"
    android:inputType="textPersonName"
    android:textColor="#FFFFFF"
    android:textColorHint="#757575"
    android:backgroundTint="#E53935"/>
```

| Attribut | Rôle |
|---|---|
| `inputType="textPersonName"` | Clavier adapté à la saisie d'un nom |
| `inputType="textEmailAddress"` | Clavier avec `@` pour l'e-mail |
| `inputType="phone"` | Clavier numérique pour le téléphone |
| `textColor="#FFFFFF"` | Texte saisi en blanc sur fond noir |
| `textColorHint="#757575"` | Placeholder en gris discret |
| `backgroundTint="#E53935"` | Soulignement rouge sous le champ |

### Bouton — `Button` (btn_envoyer)

```xml
<Button
    android:id="@+id/btn_envoyer"
    android:text="Voir le récapitulatif"
    android:backgroundTint="#E53935"
    android:textColor="#FFFFFF"/>
```

Bouton rouge qui déclenche la validation et le passage à l'écran suivant.

---

## 🖼️ Interface — `res/layout/activity_screen2.xml`

### TextViews de récapitulatif

```xml
<TextView android:id="@+id/tv_nom"
    android:textSize="16sp"
    android:textColor="#FFFFFF"/>
```

Cinq `TextView` vides au démarrage, un par champ. Ils sont remplis dynamiquement depuis `Screen2Activity.java` avec les données reçues via l'Intent.

### Bouton retour — `Button` (btn_retour)

```xml
<Button
    android:id="@+id/btn_retour"
    android:text="Retour"
    android:backgroundTint="#1A1A1A"
    android:textColor="#E53935"/>
```

Fond noir doux `#1A1A1A` avec texte rouge pour le distinguer du bouton principal tout en restant dans le thème.

---

## ☕ Logique — `MainActivity.java`

### Imports nécessaires

```java
import android.content.Intent;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
```

| Import | Rôle |
|---|---|
| `Intent` | Créer et lancer l'écran Scree2Activity |
| `android.widget.*` | Regroupe Button, EditText, Toast en un seul import |

### Récupération des champs

```java
String nom   = etNom.getText().toString().trim();
String email = etEmail.getText().toString().trim();
```

`.getText().toString()` convertit le contenu du champ en `String`. `.trim()` supprime les espaces inutiles en début et fin de saisie.

### Validation des champs

```java
if (nom.isEmpty() || email.isEmpty() || telephone.isEmpty()
        || adresse.isEmpty() || ville.isEmpty()) {
    Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
    return;
}

if (!email.contains("@")) {
    Toast.makeText(this, "E-mail invalide", Toast.LENGTH_SHORT).show();
    return;
}
```

Deux niveaux de validation : d'abord les champs vides, puis le format de l'e-mail. Si une condition échoue, un `Toast` s'affiche et `return` stoppe l'exécution.

### Intent explicite + putExtra

```java
intent.putExtra("nom",       nom);
intent.putExtra("email",     email);
intent.putExtra("telephone", telephone);
intent.putExtra("adresse",   adresse);
intent.putExtra("ville",     ville);
startActivity(intent);
```
---

## ☕ Logique — `Screen2Actuvity.java`

### Récupération des données — getStringExtra

```java
String nom   = getIntent().getStringExtra("nom");
String email = getIntent().getStringExtra("email");
```

`getIntent()` récupère l'Intent qui a lancé cet écran. `getStringExtra("clé")` extrait la valeur associée à la clé définie dans `MainActivity`.

### Affichage dans les TextView

```java
((TextView) findViewById(R.id.tv_nom)).setText("Nom    : " + nom);
((TextView) findViewById(R.id.tv_email)).setText("E-mail : " + email);
```

Chaque `TextView` est trouvé par son identifiant puis rempli par concaténation du label et de la valeur reçue.

### Bouton retour — finish()

```java
findViewById(R.id.btn_retour).setOnClickListener(v -> finish());
```

`finish()` ferme `Screen2Activity` et revient automatiquement à `MainActivity` sans en créer une nouvelle instance.

---
*Projet réalisé dans le cadre d'un apprentissage Android — AMAR SAAD*
