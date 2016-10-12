/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.backend;


import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

@Api(
        name = "unusualName",
        version = "2007",
        namespace = @ApiNamespace(
                ownerDomain = "backend.l.com",
                ownerName = "backend.l.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    public static final String STATS_URL = "https://dl.dropboxusercontent.com/u/20755008/response.json";

    @ApiMethod(name = "getStats")
    public MyBean getStats() {
        MyBean response = new MyBean();
        response.setData(new String(new HttpClient().get(STATS_URL)));
        return response;
    }

}
