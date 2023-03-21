export class SocieteRemorquageAdmin {
    email!: string;
    firstName!: string;
    lastName!: string;
    phoneNumber!: number;
    birthdate!: Date;
    gender!: string;
    matriculeFiscale!: string;

    companyId!: number; // societe remorquage
    
    country!: string;
    governorate!: string;
    city!: string;
    zipCode!: number;

    password!: string;
    confirmPassword!: string;
}
