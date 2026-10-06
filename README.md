# FitBody (Android, Java)

A small Android app with health calculators: ideal weight and daily calorie
needs. Home screen, two calculator screens, input validation and a highlighted
result shown in a Snackbar.

## Screenshots

<img width="240" alt="Home screen" src="https://github.com/user-attachments/assets/8ab4da23-e984-489b-9dfa-42404a1e7984" />
<img width="240" alt="Ideal weight calculator" src="https://github.com/user-attachments/assets/51f7ea86-8df9-40e5-9cce-b5d8e3c9ddd7" />
<img width="240" alt="Calorie calculator" src="https://github.com/user-attachments/assets/1e362906-ba8a-41c2-a687-48f5aeba698b" />

![Demo animation](https://github.com/user-attachments/assets/b6686f87-01b0-4e96-a25f-746c9ae5cbc8)

## Features

- **Ideal weight** from height and gender
- **Daily calorie needs** from age, gender, height, weight and activity level
- Validation of empty, missing and invalid input, with clear error messages
- Result shown with the value highlighted (larger, coloured text)
- Toolbar with Up navigation, info item in the app bar menu
- Edge-to-edge layout with system bar insets handled

## Formulas

| Calculator | Method |
|---|---|
| Daily calorie needs | Mifflin–St Jeor: `10·kg + 6.25·cm − 5·age + 5` (men) / `− 161` (women), multiplied by the activity factor |
| Ideal weight | Hamwi-style: base weight at 152 cm (48 kg men, 45.5 kg women) plus 1.1 / 0.9 kg for every cm above 152 |

> The results are rough estimates for information only, not medical advice.

## Code structure

```
activities/   MainActivity, IdealWeightActivity, CalorieActivity
core/         Health (calculations), Gender, BodyShape - no Android dependencies
utils/        BaseActivity, Validator, SnackbarHelper, ResultFormatter
res/          layouts, shared styles (input sections, home buttons), dimens, strings
```

- Calculations are separated from the UI, so they can be unit tested.
- `BaseActivity` holds the toolbar setup and window-insets handling shared by all screens.
- `Validator` and `SnackbarHelper` keep the activities short.
- Screens share styles (`InputSection`, `FitBodyEditText`, ...) instead of repeating attributes.

## Origin and what I added

Based on an introductory Android exercise (basic UI widgets). I reorganised it into
activities / core / utils packages and added: shared base activity, validation helper,
Snackbar result formatting, reusable styles and dimens, parent-activity navigation
and edge-to-edge support.

## Run

Open the project in Android Studio, let Gradle sync, then run on an emulator or a device.

## Roadmap

- Body shape screen (calculation and enum exist, UI not connected yet)
- Unit tests for `Health`
- Activity level as an enum instead of two parallel arrays
- ViewBinding instead of `findViewById`

## License

MIT
