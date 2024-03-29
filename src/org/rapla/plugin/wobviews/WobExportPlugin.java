/*--------------------------------------------------------------------------*
 | Copyright (C) 2006 Christopher Kohlhaas                                  |
 |                                                                          |
 | This program is free software; you can redistribute it and/or modify     |
 | it under the terms of the GNU General Public License as published by the |
 | Free Software Foundation. A copy of the license has been included with   |
 | these distribution in the COPYING file, if not go to www.fsf.org         |
 |                                                                          |
 | As a special exception, you are granted the permissions to link this     |
 | program with every library, which license fulfills the Open Source       |
 | Definition as published by the Open Source Initiative (OSI).             |
 *--------------------------------------------------------------------------*/
package org.rapla.plugin.wobviews;
import org.rapla.client.RaplaClientExtensionPoints;
import org.rapla.framework.Configuration;
import org.rapla.framework.Container;
import org.rapla.framework.PluginDescriptor;

public class WobExportPlugin implements PluginDescriptor
{
    /** FIXME we should not use static variables, and store this in the calendar settings in the next rapla version*/
	static boolean sortByPersons;
    public static final String PLUGIN_CLASS = WobExportPlugin.class.getName();

    public String toString() {
        return "Wob Preview";
    }

    /**
     * @see org.rapla.framework.PluginDescriptor#provideServices(org.rapla.framework.general.Container)
     */
    public void provideServices(Container container, Configuration config) {
        if ( !config.getAttributeAsBoolean("enabled", false) )
        	return;

        container.addContainerProvidedComponent( RaplaClientExtensionPoints.CALENDAR_VIEW_EXTENSION, WobViewFactory.class, config);
    }

    public Object getPluginMetaInfos( String key )
    {
        return null;
    }

}

