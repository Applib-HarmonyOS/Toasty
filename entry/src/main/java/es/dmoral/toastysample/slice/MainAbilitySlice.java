/*
* Copyright (C) 2020-21 Application Library Engineering Group
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*       http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package es.dmoral.toastysample.slice;

import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.text.Font;
import ohos.agp.text.RichTextBuilder;
import ohos.agp.text.TextForm;
import es.dmoral.toasty.CustomColor;
import es.dmoral.toasty.LogUtil;
import es.dmoral.toasty.Toasty;
import es.dmoral.toasty.ToastyUtils;
import es.dmoral.toastysample.ResourceTable;

/**
 * MainAbilitySlice class for Toasty sample app.
 */
public class MainAbilitySlice extends AbilitySlice {
    private static final String TAG = Toasty.class.getSimpleName();

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        initView();
    }

    private void initView() {
        findComponentById(ResourceTable.Id_button_error_toast).setClickedListener(
                new Component.ClickedListener() {
                    @Override
                    public void onClick(Component component) {
                        LogUtil.info(TAG, "button_error_toast");
                        Toasty.error(MainAbilitySlice.this, ResourceTable.String_error_message,
                                Toasty.LENGTH_SHORT, true).show();
                    }
                });
        findComponentById(ResourceTable.Id_button_success_toast).setClickedListener(
                new Component.ClickedListener() {
                    @Override
                    public void onClick(Component view) {
                        LogUtil.info(TAG, "button_success_toast");
                        Toasty.success(MainAbilitySlice.this, ResourceTable.String_success_message,
                                Toasty.LENGTH_SHORT, true).show();
                    }
                });
        findComponentById(ResourceTable.Id_button_info_toast).setClickedListener(
                new Component.ClickedListener() {
                    @Override
                    public void onClick(Component view) {
                        LogUtil.info(TAG, "button_info_toast");
                        Toasty.info(MainAbilitySlice.this, ResourceTable.String_info_message,
                                Toasty.LENGTH_SHORT, true).show();
                    }
                });
        findComponentById(ResourceTable.Id_button_warning_toast).setClickedListener(
                new Component.ClickedListener() {
                    @Override
                    public void onClick(Component component) {
                        LogUtil.info(TAG, "button_warning_toast");
                        Toasty.warning(MainAbilitySlice.this, ResourceTable.String_warning_message,
                                Toasty.LENGTH_SHORT, true).show();

                    }
                });
        findComponentById(ResourceTable.Id_button_normal_toast_wo_icon).setClickedListener(
                new Component.ClickedListener() {
                    @Override
                    public void onClick(Component component) {
                        LogUtil.info(TAG, "button_normal_toast_wo_icon");
                        Toasty.normal(MainAbilitySlice.this,
                                ResourceTable.String_normal_message_without_icon).show();
                    }
                });

        findComponentById(ResourceTable.Id_button_normal_toast_w_icon).setClickedListener(
                new Component.ClickedListener() {
                    @Override
                    public void onClick(Component component) {
                        LogUtil.info(TAG, "button_normal_toast_w_icon");
                        Toasty.normal(MainAbilitySlice.this, ResourceTable.String_normal_message_with_icon,
                                ResourceTable.Media_ic_pets_white_48dp, Toasty.LENGTH_LONG).show();
                    }
                });

        findComponentById(ResourceTable.Id_button_info_toast_with_formatting).setClickedListener(
                new Component.ClickedListener() {
                    @Override
                    public void onClick(Component component) {
                        LogUtil.info(TAG, "button_info_toast_with_formatting");
                        Toasty.info(MainAbilitySlice.this, getFormattedMessage("serif")).show();
                    }
                });
        findComponentById(ResourceTable.Id_button_custom_config).setClickedListener(
                new Component.ClickedListener() {
                    @Override
                    public void onClick(Component component) {
                        LogUtil.info(TAG, "button_custom_config");
                        CustomColor customColor = new CustomColor();
                        customColor.setCustomTextColor(ToastyUtils.getColor(MainAbilitySlice.this,
                                ResourceTable.Color_holo_green_light));
                        customColor.setCustomTintColor(ToastyUtils.getColor(MainAbilitySlice.this,
                                ResourceTable.Color_black));
                        Toasty.Config.setRtl(true);
                        Toasty.Config.allowQueue(false);
                        Toasty.Config.apply();
                        Toasty.custom(MainAbilitySlice.this, ResourceTable.String_custom_message,
                                ResourceTable.Media_laptop512, customColor, Toasty.LENGTH_LONG,
                                true, true)
                                .show();
                        Toasty.Config.reset(); // Use this if you want to use the configuration above only once
                    }
                });

    }

    private RichTextBuilder getFormattedMessage(String fontStyle) {
        LogUtil.info(TAG, "get Formatted Message");
        final String text = "Formatted";
        final String highlight = "bold italic";
        final String suffix = " text";
        TextForm textForm = new TextForm();
        textForm.setTextFont(new Font.Builder(fontStyle).makeItalic(true).setWeight(Font.BOLD).build());
        return new RichTextBuilder().mergeForm(textForm).addText(text).addText(highlight).addText(suffix);
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
