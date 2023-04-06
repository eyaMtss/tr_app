export class UpdatedUser {
    username!: string;
    country!: string;
    governorate!: string;
    city!: string;
    zipCode!: string;
    matriculeFiscale!: string;

    public constructor();
    public constructor(username: string, country: string, governorate: string, city: string, zipCode: number,
        matriculeFiscale: string);
    public constructor(...myarray: any[]){
        this.username = myarray[0];
        this.country = myarray[1];
        this.governorate = myarray[2];
        this.city = myarray[3];
        this.zipCode = myarray[4];
        this.matriculeFiscale = myarray[5];
    }
}