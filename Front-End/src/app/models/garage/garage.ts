export class Garage {
    name!: string;
    capacite!: number;
    garageOwner!: number;
    email!: string;
    phone!: number;
    countryCode!: string;
    dialCode!: string;

    adresse!: string;
    garageType!: string;

    public constructor();
    public constructor(name: string, capacity: number, garageOwner: number, email: string, 
        phone: number, adresse: string);
    public constructor(...myarray: any[]){
        this.name = myarray[0];
        this.capacite = myarray[1];
        this.email = myarray[2];
        this.garageOwner = myarray[3];
        this.email = myarray[4];
        this.phone = myarray[5];
        this.adresse = myarray[6];
    }
}
