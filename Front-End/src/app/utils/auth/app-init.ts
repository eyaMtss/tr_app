import { KeycloakOptions, KeycloakService } from "keycloak-angular";
import { config } from "process";
import { environment } from "src/environments/environment";

export function initializer(keycloak: KeycloakService): () => Promise<any> {
  return () =>
  keycloak.init({
    config: environment.keycloak,
    initOptions: {
      enableLogging: true,
      onLoad: 'check-sso',
      checkLoginIframe: false
      //silentCheckSsoRedirectUri: window.location.origin //+ '/assets/auth/silent-check-sso.html',
      //silentCheckSsoFallback: false
      //redirectUri: window.location.origin
    },
    bearerExcludedUrls: ['/assets', '/clients/public'],
    shouldUpdateToken: (request) => {
      return !request.headers.get('token-update') === false;
    }
  });
}