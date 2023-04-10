export class User {
    userId!: number;
    role!: string;
    firstName!: string;
    lastName!: string;
    email!: string;
    username!: string;
    phoneNumber!: number;
    countryCode!: string;
    dialCode!: string;
    birthdate!: Date;
    gender!: string;

    societeRemorquageId!: number; // societe remorquage
    insuranceCompanyId!: number;
    agenceLocationId!: number;

    password!: string;
    confirmPassword!: string;

    public constructor();
    public constructor(firstName: string, lastName: string, email: string, phoneNumber: number,
        birthdate: Date, gender: string);
    public constructor(...myarray: any[]){
        this.firstName = myarray[0];
        this.lastName = myarray[1];
        this.email = myarray[2];
        this.phoneNumber = myarray[3];
        this.birthdate = myarray[4];
        this.gender = myarray[5];
    }
}
