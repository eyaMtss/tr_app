export class User {
    email: string;
    firstName: string;
    lastName: string;
    phone: number;
    birthdate: Date;
    gender: string;
    matriculeFiscale: string;

    companyId: number;
    insuranceId: number;
    
    country: string;
    governorate: string;
    city: string;
    zipCode: number;
    homeCode: number;

    password: string;
    confirmPassword: string;


    constructor(email: string, firstName: string, lastName: string, phone: number, birthdate: Date,
        gender: string, matriculeFiscale: string, companyId: number, insuranceId: number,
        country: string, governorate: string, city: string, zipCode: number, homeCode: number,
        password: string, confirmPassword: string) {

        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.birthdate = birthdate;
        this.gender = gender;
        this.matriculeFiscale = matriculeFiscale;
        this.companyId = companyId;
        this.insuranceId = insuranceId;
        this.country = country;
        this.governorate = governorate;
        this.city = city;
        this.zipCode = zipCode;
        this.homeCode = homeCode;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
}
