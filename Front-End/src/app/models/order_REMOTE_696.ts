export class Order {
    id!: number;
    people!: number;
    telephone!: number;
    breakdown_type!: number;
    breakdown_details!: number;
    is_loaded!: number;
    order_time_request!: Date;
    order_time_accept!: Date;
    id_vehicule!: number;
    positionALong!: string;
    positionAAtt!: string;
    positionBLong!: string;
    positionBAtt!: string;
    positionCLong!: string;
    positionCAtt!: string;

    public constructor();
    public constructor(id: number, people: number, telephone: number, breakdown_type: number, breakdown_details: number,
        is_loaded: number, order_time_request: Date, order_time_accept: Date, id_vehicule: number,
        positionALong: string, positionAAtt: string, positionBLong: string, positionBAtt: string,
        positionCLong: string, positionCAtt: string);
    public constructor(...myarray: any[]){
        this.id = myarray[0];
        this.people = myarray[1];
        this.telephone = myarray[2];
        this.breakdown_type = myarray[3];
        this.breakdown_details = myarray[4];
        this.is_loaded = myarray[5];
        this.order_time_request = myarray[6];
        this.order_time_accept = myarray[7];
        this.id_vehicule = myarray[8];
        this.positionALong = myarray[9];
        this.positionAAtt = myarray[10];
        this.positionBLong = myarray[11];
        this.positionBAtt = myarray[12];
        this.positionCLong = myarray[13];
        this.positionCAtt = myarray[14];
    }
}
