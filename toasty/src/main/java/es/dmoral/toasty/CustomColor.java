/*
 * Copyright (C) 2020-21 Application Library Engineering Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package es.dmoral.toasty;

/**
 * Custom color model class
 */
public class CustomColor {
    private int customTintColor;
    private int customTextColor;

    public int getCustomTintColor() {
        return customTintColor;
    }

    public void setCustomTintColor(int customTintColor) {
        this.customTintColor = customTintColor;
    }

    public int getCustomTextColor() {
        return customTextColor;
    }

    public void setCustomTextColor(int customTextColor) {
        this.customTextColor = customTextColor;
    }
}
