package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

import static com.javarush.task.task16.task1631.common.ImageTypes.*;

/**
 * Created by hpg6 on 24.12.2017.
 */
public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageType) throws IllegalArgumentException {

        if (imageType == ImageTypes.JPG)
            return new JpgReader();

        if (imageType == ImageTypes.BMP)
            return new BmpReader();

        if (imageType == ImageTypes.PNG)
            return new PngReader();

        throw new IllegalArgumentException("Unknown image type");
    }
}
