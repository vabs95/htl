package com.ttn.author;

import org.apache.sling.api.resource.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.*;

@Component(service = Author.class)
public class AuthorImp implements Author {

    ResourceResolver resourceResolver = null;

    @Reference
    private ResourceResolverFactory resolverFactory;

//    @Override
//    public String getPath(String resourcePath) {
//
//        String path = "";
//        try {
//            Map<String,Object> map=new HashMap<>();
//            map.put(ResourceResolverFactory.SUBSERVICE,"Author");
//            resourceResolver = resolverFactory.getResourceResolver(map);
//            Resource res = resourceResolver.getResource(resourcePath);
//            ValueMap valueMap = res.adaptTo(ValueMap.class);
//            path = valueMap.get("path", "default");
//
//
//        } catch (LoginException e) {
//            e.printStackTrace();
//        }
//
//        return path;
//    }

    @Override
    public List getChild(String resourcePath) {
        List<Resource> childrenList = new ArrayList<>();
        try {
            Map<String,Object> map=new HashMap<>();
            map.put(ResourceResolverFactory.SUBSERVICE,"Author");
            resourceResolver = resolverFactory.getServiceResourceResolver(map);
            Resource res = resourceResolver.getResource(resourcePath);
            Iterator<Resource> resourceIterator = res.listChildren();

            while (resourceIterator.hasNext()) {
                childrenList.add(resourceIterator.next());
            }

        } catch (LoginException e) {
            e.printStackTrace();
        }
        return childrenList;

    }
}
