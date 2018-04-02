/*
 * Copyright (c) Microsoft. All rights reserved. Licensed under the MIT license.
 * See LICENSE in the project root for license information.
 */
package com.microsoft.graph.snippets.application;

import android.app.Application;
import android.content.Context;

import com.microsoft.graph.core.DefaultClientConfig;
import com.microsoft.graph.core.IClientConfig;
import com.microsoft.graph.extensions.GraphServiceClient;
import com.microsoft.graph.extensions.IGraphServiceClient;
import com.microsoft.graph.snippets.AuthenticationManager;

//import javax.inject.Inject;
//
//import dagger.ObjectGraph;

public class SnippetApp extends Application {
    private static SnippetApp sSnippetApp;

    public static SnippetApp getApp() {
        return sSnippetApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sSnippetApp = this;
    }

    public IGraphServiceClient getGraphServiceClient() {
        IClientConfig clientConfig = DefaultClientConfig.createWithAuthenticationProvider(
            AuthenticationManager.getInstance()
        );
        return new GraphServiceClient.Builder().fromConfig(clientConfig).buildClient();
    }
    public static Context getContext(){
        return sSnippetApp;
    }
}
