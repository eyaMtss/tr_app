export class Lavage {
    name!: string;
    capacity!: number;
    currentNbVehicle!: number;
    lavageOwner!: string;
    email!: string;
    phone!: number;
    countryCode!: string;
    dialCode!: string;
    address!: string;

    public constructor();
    public constructor(name: string, capacity: number, currentNbVehicle: number, lavageOwner: number,
        email: string, phone: number, address: string);
    public constructor(...myarray: any[]){
        this.name = myarray[0];
        this.capacity = myarray[1];
        this.email = myarray[2];
        this.currentNbVehicle = myarray[3];
        this.lavageOwner = myarray[4];
        this.email = myarray[5];
        this.phone = myarray[6];
        this.address = myarray[7];
    }
}
