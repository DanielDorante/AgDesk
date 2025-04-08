package com.example.agdesk.Application;

import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedEntryPoint;

@OriginatingElement(
    topLevelClass = AgDesk.class
)
@GeneratedEntryPoint
@InstallIn(SingletonComponent.class)
public interface AgDesk_GeneratedInjector {
  void injectAgDesk(AgDesk agDesk);
}
