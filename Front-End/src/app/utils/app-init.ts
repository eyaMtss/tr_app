import { KeycloakOptions, KeycloakService } from "keycloak-angular";
import { config } from "process";
import { environment } from "src/environments/environment";

export function initializer(keycloak: KeycloakService): () => Promise<any> {
  return () =>
  keycloak.init({
    config: environment.keycloak,
    initOptions: {
      onLoad: 'check-sso',
      enableLogging: true,
       redirectUri: window.location.origin,   
    },
  });
}