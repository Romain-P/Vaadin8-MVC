package org.vaadinmvc.util;

import com.google.common.base.Strings;
import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Image;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @Author: romain.pillot
 * @Date: 06/07/2017
 */
public class ResourceUtil {
    private static final String base = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();

    public static Image getImage(@Nullable String motion, @NotNull Resource resource)
    {
        FileResource fileResource = new FileResource(new File(base, resource.getPath()));
        return (new Image(Strings.nullToEmpty(motion), fileResource));
    }
}
