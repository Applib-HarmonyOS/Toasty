package es.dmoral.toasty;

import ohos.agp.colors.RgbColor;
import ohos.agp.components.Component;
import ohos.agp.components.element.Element;
import ohos.agp.components.element.PixelMapElement;
import ohos.agp.components.element.ShapeElement;
import ohos.agp.components.element.VectorElement;
import ohos.app.Context;
import ohos.global.resource.NotExistException;
import ohos.global.resource.RawFileEntry;
import ohos.global.resource.Resource;
import ohos.global.resource.ResourceManager;
import ohos.global.resource.WrongTypeException;
import ohos.media.image.ImageSource;
import ohos.media.image.PixelMap;
import java.io.IOException;

/**
 * This file is part of Toasty.
 *
 * Toasty is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Toasty is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Toasty. If not, see http://www.gnu.org/licenses/
 */

public final class ToastyUtils {
    private static final String TAG = ToastyUtils.class.getSimpleName();

    private ToastyUtils() {
    }

    static Element tintDrawableFrame(int tintColor) {
        final ShapeElement toastFrame = new ShapeElement();
        toastFrame.setCornerRadius(20);
        toastFrame.setRgbColor(new RgbColor(RgbColor.fromArgbInt(tintColor)));
        return toastFrame;
    }

    public static void setBackground(Component view, Element backgroundElement) {
        view.setBackground(backgroundElement);
    }

    /**
     * Returning int color value from color resource id.
     *
     * @param context context
     * @param color color resource id
     * @return int color value
     */
    public static int getColor(Context context, int color) {
        try {
            return context.getResourceManager().getElement(color).getColor();
        } catch (IOException | NotExistException | WrongTypeException e) {
            LogUtil.error(TAG, e.getMessage());
        }
        return 0;
    }

    /**
     * Returning VectorElement from Element resource id.
     *
     * @param context context
     * @param id element resource id
     * @return VectorElement instance
     */
    public static VectorElement getVectorElement(Context context, int id) {
        if (context != null) {
            return new VectorElement(context, id);
        }
        return null;
    }

    private static String getPathById(Context context, int resId) {
        String path = "";
        ResourceManager resourceManager = context.getResourceManager();
        if (resourceManager != null) {
            try {
                path = resourceManager.getMediaPath(resId);

            } catch (IOException | NotExistException | WrongTypeException e) {
                LogUtil.error(TAG, e.getMessage());
            }
        }
        return path;
    }

    /**
     * Returning VectorElement from Element resource id.
     *
     * @param context context
     * @param resId element resource id
     * @return PixelMapElement instance
     */
    public static PixelMapElement getPixelMapElement(Context context, int resId) {
        String path = getPathById(context, resId);
        PixelMapElement pixelMapElement = null;
        if (path != null) {
            RawFileEntry fileEntry = context.getResourceManager().getRawFileEntry(path);
            ImageSource.SourceOptions sourceOptions = new ImageSource.SourceOptions();
            sourceOptions.formatHint = "image/png";
            ImageSource.DecodingOptions decodingOptions = new ImageSource.DecodingOptions();
            try {
                Resource resource = fileEntry.openRawFile();
                ImageSource imageSource = ImageSource.create(resource, sourceOptions);
                PixelMap pixelMap = imageSource.createPixelmap(decodingOptions);
                pixelMapElement = new PixelMapElement(pixelMap);
            } catch (IOException e) {
                LogUtil.error(TAG, e.getMessage());
            }
        }
        return pixelMapElement;
    }
}
