export class Token {

    id: number;
    email: string;
    firstname: string;
    lastname: string;
    username: string;

    constructor(id: number, email: string, firstname: string, 
        lastname: string, username: string){
            this.id = id;
            this.email = email;
            this.firstname = firstname;
            this.lastname = lastname;
            this.username = username;
        }
}
