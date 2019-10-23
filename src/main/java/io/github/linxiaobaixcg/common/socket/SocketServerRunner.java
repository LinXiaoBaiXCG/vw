package io.github.linxiaobaixcg.common.socket;

import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SocketServerRunner implements CommandLineRunner {

  @Autowired
  private SocketIOServer server;

  @Override
  public void run(String... args) {
    server.start();
  }
}