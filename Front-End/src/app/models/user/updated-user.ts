export class UpdatedUser {
    userId!: number;
    username!: string;
    country!: string;
    governorate!: string;
    city!: string;
    zipCode!: number;
    matriculeFiscale!: string;
    cin!: number;

    public constructor();
    public constructor(username: string, country: string, governorate: string, city: string, zipCode: number,
        matriculeFiscale: string, cin: number);
    public constructor(...myarray: any[]){
        this.username = myarray[0];
        this.country = myarray[1];
        this.governorate = myarray[2];
        this.city = myarray[3];
        this.zipCode = myarray[4];
        this.matriculeFiscale = myarray[5];
        this.cin = myarray[6];
    }
}
