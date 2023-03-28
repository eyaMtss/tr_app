export class User {
    firstName!: string;
    lastName!: string;
    email!: string;
    username!: string;
    phoneNumber!: number;
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
        this.firstName = myarray[1];
        this.lastName = myarray[2];
        this.email = myarray[3];
        this.phoneNumber = myarray[4];
        this.birthdate = myarray[5];
        this.gender = myarray[6];
    }
}
