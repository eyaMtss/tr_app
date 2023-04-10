export class Garage {
    name!: string;
    capacity!: number;
    garageOwner!: string;
    email!: string;
    phone!: number;
    address!: string;
    garageType!: string;

    public constructor();
    public constructor(name: string, capacity: number, garageOwner: string, email: string, 
        phone: number, address: string);
    public constructor(...myarray: any[]){
        this.name = myarray[0];
        this.capacity = myarray[1];
        this.email = myarray[2];
        this.garageOwner = myarray[3];
        this.email = myarray[4];
        this.phone = myarray[5];
        this.address = myarray[6];
    }
}
