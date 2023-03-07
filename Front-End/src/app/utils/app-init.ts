import { KeycloakOptions, KeycloakService } from "keycloak-angular";
import { config } from "process";
import { environment } from "src/environments/environment";

export function initializer(keycloak: KeycloakService): () => Promise<any> {
  const options: KeycloakOptions = {
    config: environment.keycloak
  };
  return (): Promise<any> => keycloak.init(options);
}