# MaDialog
Material Alert Dialog

[![](https://jitpack.io/v/umairayub79/MaDialog.svg)](https://jitpack.io/#umairayub79/MaDialog)

- min SDK 16
- was written in Java now in Kotlin
- simple beautiful dialogs with image and GIF support


## Screenshots
![Example screenshot 1](./example_screenshots/example_screenshot1.jpg)
![Example screenshot 2](./example_screenshots/example_screenshot2.jpg)
![Example screenshot 3](./example_screenshots/example_screenshot3.jpg)


## Installation
Add this into your project's root build.gradle file
```java
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
Add the dependency to your module build.gradle:
```java
dependencies {
	implementation 'com.github.umairayub79:MaDialog:1.5'
}
```

## Example Usage
```java
//build a simple dialog

 new MaDialog.Builder(MainActivity.this)
                        .setTitle("Example Dialog")
                        .setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis scelerisquevel. ")
                        .setPositiveButtonText("ok")
                        .setNegativeButtonText("cancel")
			setButtonOrientation(LinearLayout.HORIZONTAL)
                        .AddNewButton(R.style.AppTheme, "Yes", new MaDialogListener() {
                            @Override
                            public void onClick() {

                            }
                        })
                        .setPositiveButtonListener(new MaDialogListener() {
                            @Override
                            public void onClick() {
                              //todo
                            }
                        })
                        .setNegativeButtonListener(new MaDialogListener() {
                            @Override
                            public void onClick() {
                              //todo
                            }
                        })
                        .build();


//Available Methods

.setTitle(String);
.setMessage(String);
.setImage(int);
.setGif(int);
.setMessageTextColor(int);
.setTitleTextColor(int);
.setButtonTextColor(int);
.AddNewButton(int,String,MaDialogListener);
.setButtonOrientation(int);
.setBackgroundColor(int);
.setNegativeButtonText(String);
.setPositiveButtonText(String);
.setPositiveButtonTextColor(int)
.setNegativeButtonTextColor(int)
.setCancelableOnOutsideTouch(boolean);
.setPositiveButtonListener(MaDialogListener);
.setNegativeButtonListener(MaDialogListener);
.build();

```


# LICENSE

```
   Copyright 2020 Umair Ayub

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

```
