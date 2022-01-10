package es.dmoral.toasty;

import ohos.agp.components.Component;
import ohos.agp.components.DirectionalLayout;
import ohos.agp.components.Image;
import ohos.agp.components.LayoutScatter;
import ohos.agp.components.Text;
import ohos.agp.components.element.Element;
import ohos.agp.components.element.PixelMapElement;
import ohos.agp.components.element.VectorElement;
import ohos.agp.text.Font;
import ohos.agp.text.RichTextBuilder;
import ohos.agp.utils.Color;
import ohos.agp.utils.LayoutAlignment;
import ohos.agp.window.dialog.ToastDialog;
import ohos.app.Context;
import ohos.global.configuration.Configuration;

/**
 * This file is part of Toasty.
 * <p>
 * Toasty is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * Toasty is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with Toasty. If not, see http://www.gnu.org/licenses/
 */

public class Toasty {
    private static Font currentTypeface = Font.DEFAULT;
    private static int textSize = 16; // in SP
    private static boolean tintIcon = true;
    private static boolean allowQueue = true;
    private static int toastGravity = -1;
    private static int offsetX = -1;
    private static int offsetY = -1;
    private static boolean isRtl = false;

    private static ToastDialog lastToast = null;

    public static final int LENGTH_SHORT = 2000;
    public static final int LENGTH_LONG = 3000;

    private Toasty() {
        // avoiding instantiation
    }

    public static ToastDialog normal(Context context, int message) {
        return normal(context, context.getString(message), Toasty.LENGTH_SHORT, null, false);
    }

    public static ToastDialog normal(Context context, CharSequence message) {
        return normal(context, message, Toasty.LENGTH_SHORT, null, false);
    }

    public static ToastDialog normal(Context context, int message, Element icon) {
        return normal(context, context.getString(message), Toasty.LENGTH_SHORT, icon, true);
    }

    public static ToastDialog normal(Context context, CharSequence message, Element icon) {
        return normal(context, message, Toasty.LENGTH_SHORT, icon, true);
    }

    public static ToastDialog normal(Context context, int message, int duration) {
        return normal(context, context.getString(message), duration, null, false);
    }

    public static ToastDialog normal(Context context, int message, int iconId, int duration) {
        return normal(context, message, duration, iconId, true);
    }

    public static ToastDialog normal(Context context, CharSequence message, int duration) {
        return normal(context, message, duration, null, false);
    }

    public static ToastDialog normal(Context context, int message, int duration,
                                     Element icon) {
        return normal(context, context.getString(message), duration, icon, true);
    }

    public static ToastDialog normal(Context context, CharSequence message, int duration,
                                     Element icon) {
        return normal(context, message, duration, icon, true);
    }

    public static ToastDialog normal(Context context, int message, int duration,
                                      Element icon, boolean withIcon) {
        return normalWithDarkThemeSupport(context, context.getString(message), icon,
                duration, withIcon);
    }

    public static ToastDialog normal(Context context, CharSequence message, int duration,
                                      Element icon, boolean withIcon) {
        return normalWithDarkThemeSupport(context, message, icon, duration, withIcon);
    }

    public static ToastDialog normal(Context context, int message, int duration,
                                     int iconId, boolean withIcon) {
        return normalWithDarkThemeSupport(context, context.getString(message), iconId,
                duration, withIcon);
    }

    public static ToastDialog warning(Context context, int message) {
        return warning(context, context.getString(message), Toasty.LENGTH_SHORT, true);
    }


    public static ToastDialog warning(Context context, CharSequence message) {
        return warning(context, message, Toasty.LENGTH_SHORT, true);
    }

    public static ToastDialog warning(Context context, int message, int duration) {
        return warning(context, context.getString(message), duration, true);
    }

    public static ToastDialog warning(Context context, CharSequence message, int duration) {
        return warning(context, message, duration, true);
    }

    /**
     * Warning method for ToastDialog.
     *
     * @param context context
     * @param message custom message
     * @param duration custom duration
     * @param withIcon custom icon
     * @return warning Toast Dialog
     */
    public static ToastDialog warning(Context context, int message, int duration,
                                      boolean withIcon) {
        CustomColor customColor = new CustomColor();
        customColor.setCustomTextColor(ToastyUtils.getColor(context, ResourceTable.Color_defaultTextColor));
        customColor.setCustomTintColor(ToastyUtils.getColor(context, ResourceTable.Color_warningColor));
        return custom(context, context.getString(message), ToastyUtils.getVectorElement(context,
                ResourceTable.Graphic_ic_error_outline_white_24dp), customColor, duration,
                withIcon, true);
    }

    /**
     * warning method for ToastDialog.
     *
     * @param context context
     * @param message custom message
     * @param duration custom duration
     * @param withIcon custom icon
     * @return warning Toast Dialog
     */
    public static ToastDialog warning(Context context, CharSequence message, int duration,
                                       boolean withIcon) {
        CustomColor customColor = new CustomColor();
        customColor.setCustomTextColor(ToastyUtils.getColor(context, ResourceTable.Color_defaultTextColor));
        customColor.setCustomTintColor(ToastyUtils.getColor(context, ResourceTable.Color_warningColor));
        return custom(context, message, ToastyUtils.getVectorElement(context,
                ResourceTable.Graphic_ic_error_outline_white_24dp), customColor, duration,
                withIcon, true);
    }

    public static ToastDialog info(Context context, int message) {
        return info(context, context.getString(message), Toasty.LENGTH_SHORT, true);
    }

    public static ToastDialog info(Context context, CharSequence message) {
        return info(context, message, Toasty.LENGTH_SHORT, true);
    }

    public static ToastDialog info(Context context, RichTextBuilder message) {
        return info(context, message, Toasty.LENGTH_SHORT, true);
    }

    public static ToastDialog info(Context context, int message, int duration) {
        return info(context, context.getString(message), duration, true);
    }

    public static ToastDialog info(Context context, CharSequence message, int duration) {
        return info(context, message, duration, true);
    }

    /**
     * Info method for ToastDialog.
     *
     * @param context context
     * @param message custom message
     * @param duration custom duration
     * @param withIcon custom Icon
     * @return Info Toast Dialog
     */
    public static ToastDialog info(Context context, int message, int duration, boolean withIcon) {
        CustomColor customColor = new CustomColor();
        customColor.setCustomTextColor(ToastyUtils.getColor(context, ResourceTable.Color_defaultTextColor));
        customColor.setCustomTintColor(ToastyUtils.getColor(context, ResourceTable.Color_infoColor));
        return custom(context, context.getString(message), ToastyUtils.getVectorElement(context,
                ResourceTable.Graphic_ic_info_outline_white_24dp), customColor, duration,
                withIcon, true);
    }

    /**
     * Info method for ToastDialog.
     *
     * @param context context
     * @param message custom message
     * @param duration custom duration
     * @param withIcon custom
     * @return Info ToastDialog
     */
    public static ToastDialog info(Context context, CharSequence message, int duration, boolean withIcon) {
        CustomColor customColor = new CustomColor();
        customColor.setCustomTextColor(ToastyUtils.getColor(context, ResourceTable.Color_defaultTextColor));
        customColor.setCustomTintColor(ToastyUtils.getColor(context, ResourceTable.Color_infoColor));
        return custom(context, message, ToastyUtils.getVectorElement(context,
                ResourceTable.Graphic_ic_info_outline_white_24dp), customColor, duration,
                withIcon, true);
    }

    /**
     * Info method for ToastDialog.
     *
     * @param context context
     * @param message custom message
     * @param duration custom duration
     * @param withIcon customIcon
     * @return Info ToastDialog
     */
    public static ToastDialog info(Context context, RichTextBuilder message, int duration, boolean withIcon) {
        CustomColor customColor = new CustomColor();
        customColor.setCustomTextColor(ToastyUtils.getColor(context, ResourceTable.Color_defaultTextColor));
        customColor.setCustomTintColor(ToastyUtils.getColor(context, ResourceTable.Color_infoColor));
        return custom(context, message, ToastyUtils.getVectorElement(context,
                ResourceTable.Graphic_ic_info_outline_white_24dp), customColor, duration,
                withIcon, true);
    }

    public static ToastDialog success(Context context, int message) {
        return success(context, context.getString(message), Toasty.LENGTH_SHORT, true);
    }

    public static ToastDialog success(Context context, CharSequence message) {
        return success(context, message, Toasty.LENGTH_SHORT, true);
    }

    public static ToastDialog success(Context context, int message, int duration) {
        return success(context, context.getString(message), duration, true);
    }

    public static ToastDialog success(Context context, CharSequence message, int duration) {
        return success(context, message, duration, true);
    }

    /**
     * success method for ToastDialog.
     *
     * @param context context
     * @param message custom message
     * @param duration custom duration
     * @param withIcon Icon
     * @return success ToastDialog
     */
    public static ToastDialog success(Context context, int message, int duration, boolean withIcon) {
        CustomColor customColor = new CustomColor();
        customColor.setCustomTextColor(ToastyUtils.getColor(context, ResourceTable.Color_defaultTextColor));
        customColor.setCustomTintColor(ToastyUtils.getColor(context, ResourceTable.Color_successColor));
        return custom(context, context.getString(message), ToastyUtils.getVectorElement(context,
                ResourceTable.Graphic_ic_check_white_24dp), customColor, duration, withIcon, true);
    }

    /**
     * success method for ToastDialog.
     *
     * @param context context
     * @param message custom message
     * @param duration custom duration
     * @param withIcon Icon
     * @return success Toast Dialog
     */
    public static ToastDialog success(Context context, CharSequence message, int duration, boolean withIcon) {
        CustomColor customColor = new CustomColor();
        customColor.setCustomTextColor(ToastyUtils.getColor(context, ResourceTable.Color_defaultTextColor));
        customColor.setCustomTintColor(ToastyUtils.getColor(context, ResourceTable.Color_successColor));
        return custom(context, message, ToastyUtils.getVectorElement(context,
                ResourceTable.Graphic_ic_check_white_24dp), customColor, duration, withIcon, true);
    }

    public static ToastDialog error(Context context, int message) {
        return error(context, context.getString(message), Toasty.LENGTH_SHORT, true);
    }

    public static ToastDialog error(Context context, CharSequence message) {
        return error(context, message, Toasty.LENGTH_SHORT, true);
    }

    public static ToastDialog error(Context context, int message, int duration) {
        return error(context, context.getString(message), duration, true);
    }

    public static ToastDialog error(Context context, CharSequence message, int duration) {
        return error(context, message, duration, true);
    }

    /**
     * Error method for ToastDialog.
     *
     * @param context context
     * @param message custom message
     * @param duration custom duration
     * @param withIcon Icon
     * @return Error Toast Dialog
     */
    public static ToastDialog error(Context context, int message, int duration, boolean withIcon) {
        CustomColor customColor = new CustomColor();
        customColor.setCustomTextColor(ToastyUtils.getColor(context, ResourceTable.Color_defaultTextColor));
        customColor.setCustomTintColor(ToastyUtils.getColor(context, ResourceTable.Color_errorColor));
        return custom(context, context.getString(message), ToastyUtils.getVectorElement(context,
                ResourceTable.Graphic_ic_clear_white_24dp), customColor, duration, withIcon, true);
    }

    /**
     * Error method for ToastDialog.
     *
     * @param context context
     * @param message custom message
     * @param duration duration
     * @param withIcon Icon
     * @return Error ToastDialog
     */
    public static ToastDialog error(Context context, CharSequence message,
                                    int duration, boolean withIcon) {
        CustomColor customColor = new CustomColor();
        customColor.setCustomTextColor(ToastyUtils.getColor(context, ResourceTable.Color_defaultTextColor));
        customColor.setCustomTintColor(ToastyUtils.getColor(context, ResourceTable.Color_errorColor));
        return custom(context, message, ToastyUtils.getVectorElement(context,
                ResourceTable.Graphic_ic_clear_white_24dp), customColor, duration, withIcon, true);
    }

    /**
     * Custom method for ToastDialog.
     *
     * @param context context
     * @param message custom message
     * @param iconRes custom iconRes
     * @param tintColorRes custom tintColorRes
     * @param duration custom duration
     * @param withIcon custom withIcon
     * @param shouldTint custom shouldTint
     * @return Custom Toast Dialog
     */
    public static ToastDialog custom(Context context, int message, int iconRes,
                                      int tintColorRes, int duration,
                                      boolean withIcon, boolean shouldTint) {
        CustomColor customColor = new CustomColor();
        customColor.setCustomTextColor(ToastyUtils.getColor(context, ResourceTable.Color_defaultTextColor));
        customColor.setCustomTintColor(ToastyUtils.getColor(context, tintColorRes));
        return custom(context, context.getString(message),
                ToastyUtils.getPixelMapElement(context, iconRes),
                customColor, duration, withIcon, shouldTint);
    }

    /**
     * Custom method for ToastDialog.
     *
     * @param context context
     * @param message custom message
     * @param iconRes custom iconRes
     * @param tintColorRes custom tintColorRes
     * @param duration custom duration
     * @param withIcon custom withIcon
     * @param shouldTint custom shouldTint
     * @return Custom Toast Dialog
     */
    public static ToastDialog custom(Context context, CharSequence message, int iconRes,
                                     int tintColorRes, int duration,
                                     boolean withIcon, boolean shouldTint) {
        CustomColor customColor = new CustomColor();
        customColor.setCustomTextColor(ToastyUtils.getColor(context, ResourceTable.Color_defaultTextColor));
        customColor.setCustomTintColor(ToastyUtils.getColor(context, tintColorRes));
        return custom(context, message, ToastyUtils.getVectorElement(context, iconRes),
                customColor, duration, withIcon, shouldTint);
    }

    /**
     * Custom method for ToastDialog.
     *
     * @param context custom context
     * @param message custom message
     * @param iconRes custom iconRes
     * @param customColor custom tint and text Color
     * @param duration custom duration
     * @param withIcon custom withIcon
     * @param shouldTint custom shouldTint
     * @return Custom Toast Dialog
     */
    public static ToastDialog custom(Context context, int message, int iconRes,
                                      CustomColor customColor, int duration,
                                      boolean withIcon, boolean shouldTint) {
        return custom(context, context.getString(message), ToastyUtils.getPixelMapElement(context, iconRes),
                customColor, duration, withIcon, shouldTint);
    }

    /**
     * Custom method for ToastDialog.
     *
     * @param context custom context
     * @param message custom message
     * @param icon custom icon
     * @param customColor custom tint and text Color
     * @param duration custom duration
     * @param withIcon custom withIcon
     * @param shouldTint custom shouldTint
     * @return Custom Toast Dialog
     */
    public static ToastDialog custom(Context context, CharSequence message, Element icon,
                                      CustomColor customColor, int duration,
                                      boolean withIcon, boolean shouldTint) {
        final ToastDialog currentToast = new ToastDialog(context);
        currentToast.setText("");
        currentToast.setDuration(duration);
        LayoutScatter layoutScatter = LayoutScatter.getInstance(context);
        final Component toastLayout = layoutScatter.parse(ResourceTable.Layout_toast_layout,
                null, false);
        final DirectionalLayout toastRoot = (DirectionalLayout) toastLayout.findComponentById(
                ResourceTable.Id_toast_root);
        final Image toastIcon = (Image) toastLayout.findComponentById(ResourceTable.Id_toast_icon);
        final Text toastTextView = (Text) toastLayout.findComponentById(ResourceTable.Id_toast_text);
        Element drawableFrame = null;

        if (shouldTint) {
            drawableFrame = ToastyUtils.tintDrawableFrame(customColor.getCustomTintColor());
        }
        else {
            drawableFrame = ToastyUtils.tintDrawableFrame(
                    ToastyUtils.getColor(context, ResourceTable.Color_default_tint_color));
        }
        ToastyUtils.setBackground(toastLayout, drawableFrame);
        if (withIcon) {
            if (icon == null) {
                throw new IllegalArgumentException("Avoid passing 'icon' as null if 'withIcon' is set to true");
            }
            if (isRtl) {
                toastRoot.setLayoutDirection(Component.LayoutDirection.RTL);
            }
            if (icon instanceof VectorElement) {
                toastIcon.setImageElement(icon);
            } else if (icon instanceof PixelMapElement) {
                toastIcon.setPixelMap(((PixelMapElement) icon).getPixelMap());
            }
        } else {
            toastIcon.setVisibility(Component.HIDE);
        }
        toastTextView.setText((String) message);
        toastTextView.setTextColor(new Color(customColor.getCustomTextColor()));
        toastTextView.setFont(currentTypeface);
        toastTextView.setTextSize(textSize, Text.TextSizeType.VP);

        currentToast.setComponent(toastLayout);

        if (!allowQueue) {
            if (lastToast != null) {
                lastToast.cancel();
            }
            lastToast = currentToast;
        }
        // Make sure to use default values for non-specified ones.
        currentToast.setAlignment(LayoutAlignment.HORIZONTAL_CENTER | LayoutAlignment.BOTTOM);
        currentToast.setOffset(offsetX, 50);
        return currentToast;
    }

    /**
     * Custom method for ToastDialog.
     *
     * @param context custom context
     * @param message custom message
     * @param icon custom icon
     * @param customColor custom tint and text Color
     * @param duration custom duration
     * @param withIcon custom withIcon
     * @param shouldTint custom shouldTint
     * @return Custom Toast Dialog
     */
    public static ToastDialog custom(Context context, RichTextBuilder message, Element icon,
                                     CustomColor customColor, int duration,
                                     boolean withIcon, boolean shouldTint) {
        final ToastDialog currentToast = new ToastDialog(context);
        currentToast.setText("");
        currentToast.setDuration(duration);
        LayoutScatter layoutScatter = LayoutScatter.getInstance(context);
        final Component toastLayout = layoutScatter.parse(ResourceTable.Layout_toast_layout,
                null, false);
        final DirectionalLayout toastRoot = (DirectionalLayout) toastLayout.findComponentById(
                ResourceTable.Id_toast_root);
        final Image toastIcon = (Image) toastLayout.findComponentById(ResourceTable.Id_toast_icon);
        final Text toastTextView = (Text) toastLayout.findComponentById(ResourceTable.Id_toast_text);
        Element drawableFrame = null;

        toastTextView.setRichText(message.build());
        toastTextView.setTextColor(new Color(customColor.getCustomTextColor()));
        toastTextView.setFont(currentTypeface);
        toastTextView.setTextSize(textSize, Text.TextSizeType.VP);

        if (shouldTint) {
            drawableFrame = ToastyUtils.tintDrawableFrame(customColor.getCustomTintColor());
        }
        else {
            drawableFrame = ToastyUtils.tintDrawableFrame(
                    ToastyUtils.getColor(context, ResourceTable.Color_default_tint_color));
        }

        ToastyUtils.setBackground(toastLayout, drawableFrame);
        if (withIcon) {
            if (icon == null) {
                throw new IllegalArgumentException("Avoid passing 'icon' as null if 'withIcon' is set to true");
            }
            if (isRtl) {
                toastRoot.setLayoutDirection(Component.LayoutDirection.RTL);
            }
            if (icon instanceof VectorElement) {
                toastIcon.setImageElement(icon);
            } else if (icon instanceof PixelMapElement) {
                toastIcon.setPixelMap(((PixelMapElement) icon).getPixelMap());
            }
        } else {
            toastIcon.setVisibility(Component.HIDE);
        }

        currentToast.setComponent(toastLayout);

        if (!allowQueue && lastToast != null) {
            lastToast.cancel();
            lastToast = currentToast;
        }
        // Make sure to use default values for non-specified ones.
        currentToast.setAlignment(LayoutAlignment.HORIZONTAL_CENTER | LayoutAlignment.BOTTOM);
        currentToast.setOffset(offsetX, 50);
        return currentToast;
    }

    private static ToastDialog normalWithDarkThemeSupport(Context context, CharSequence message, Element icon,
                                                           int duration, boolean withIcon) {
        int uiMode = context.getResourceManager().
                getConfiguration().colorMode & Configuration.DARK_MODE;
        if (uiMode == Configuration.AUTO_MODE) {
            return withLightTheme(context, message, icon, duration, withIcon);
        }
        return withDarkTheme(context, message, icon, duration, withIcon);
    }

    private static ToastDialog normalWithDarkThemeSupport(Context context, CharSequence message, int iconId,
                                                          int duration, boolean withIcon) {
        int uiMode = context.getResourceManager().
                getConfiguration().colorMode & Configuration.DARK_MODE;
        Element icon = ToastyUtils.getPixelMapElement(context, iconId);
        if (uiMode == Configuration.AUTO_MODE) {
            return withLightTheme(context, message, icon, duration, withIcon);
        }
        return withDarkTheme(context, message, icon, duration, withIcon);
    }

    private static ToastDialog withLightTheme(Context context, CharSequence message, Element icon,
                                               int duration, boolean withIcon) {
        CustomColor customColor = new CustomColor();
        customColor.setCustomTextColor(ToastyUtils.getColor(context, ResourceTable.Color_defaultTextColor));
        customColor.setCustomTintColor(ToastyUtils.getColor(context, ResourceTable.Color_normalColor));
        return custom(context, message, icon, customColor, duration, withIcon, true);
    }

    private static ToastDialog withDarkTheme(Context context, CharSequence message, Element icon,
                                              int duration, boolean withIcon) {
        CustomColor customColor = new CustomColor();
        customColor.setCustomTextColor(ToastyUtils.getColor(context, ResourceTable.Color_defaultTextColor));
        customColor.setCustomTintColor(ToastyUtils.getColor(context, ResourceTable.Color_normalColor));
        return custom(context, message, icon, customColor, duration, withIcon, true);
    }

    /**
     * Config class for Toasty.
     */
    public static class Config {
        private static Font typeface = Toasty.currentTypeface;
        private static int textSize = Toasty.textSize;
        private static boolean tintIcon = Toasty.tintIcon;
        private static boolean allowQueue = true;
        private static int toastGravity = Toasty.toastGravity;
        private static int offsetX = Toasty.offsetX;
        private static int offsetY = Toasty.offsetY;
        private static boolean isRtl = false;

        private Config() {
            // avoiding instantiation
        }

        public static Config getInstance() {
            return new Config();
        }

        /**
         * reset() for Toasty.
         */
        public static void reset() {
            Toasty.currentTypeface = Font.DEFAULT;
            Toasty.textSize = 16;
            Toasty.tintIcon = true;
            Toasty.allowQueue = true;
            Toasty.toastGravity = -1;
            Toasty.offsetX = -1;
            Toasty.offsetY = -1;
            Toasty.isRtl = false;
        }

        public Config setToastTypeface(Font typeface) {
            this.typeface = typeface;
            return this;
        }

        public Config setTextSize(int sizeInSp) {
            this.textSize = sizeInSp;
            return this;
        }

        public Config tintIcon(boolean tintIcon) {
            this.tintIcon = tintIcon;
            return this;
        }

        public Config allowQueue(boolean allowQueue) {
            this.allowQueue = allowQueue;
            return this;
        }

        /**
         * SetGravity for ToastDialog.
         *
         * @param gravity toastGravity
         * @param offsetX offsetX
         * @param offsetY offsetY
         * @return Config instance
         */
        public Config setGravity(int gravity, int offsetX, int offsetY) {
            this.toastGravity = gravity;
            this.offsetX = offsetX;
            this.offsetY = offsetY;
            return this;
        }

        public Config setGravity(int gravity) {
            this.toastGravity = gravity;
            return this;
        }

        public Config setRtl(boolean isRtl) {
            this.isRtl = isRtl;
            return this;
        }

        /**
         * apply() for Toasty.
         */
        public void apply() {
            Toasty.currentTypeface = typeface;
            Toasty.textSize = textSize;
            Toasty.tintIcon = tintIcon;
            Toasty.allowQueue = allowQueue;
            Toasty.toastGravity = toastGravity;
            Toasty.offsetX = offsetX;
            Toasty.offsetY = offsetY;
            Toasty.isRtl = isRtl;
        }
    }
}
