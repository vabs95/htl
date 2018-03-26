package com.ttn.author;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.scripting.SlingScriptHelper;
import org.apache.sling.scripting.sightly.pojo.Use;

import javax.script.Bindings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Application implements Use {

    List childList = new ArrayList<>();

    @Override
    public void init(Bindings bindings) {

        Resource resource = (Resource) bindings.get("resource");
        String path = (String) resource.getValueMap().get("path");
        System.out.println(path);
        SlingScriptHelper slingScriptHelper = (SlingScriptHelper) bindings.get("sling");
        com.ttn.author.Author author = slingScriptHelper.getService(com.ttn.author.Author.class);

        childList = author.getChild(path);
    }

    public List getChildList() {
        return childList;
    }
}
