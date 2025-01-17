import http from "../http-common";

class TypeCompteService {
    getAll() {
        return http.get("/typeCompte/");
    }

    get(id) {
        return http.get(`/typeCompte/${id}`);
    }

    create(data) {
        return http.post("/typeCompte/", data);
    }

    update(id, data) {
        return http.put(`/typeCompte/${id}`, data);
    }

    delete(id) {
        return http.delete(`/typeCompte/${id}`);
    }



    findById(title) {
        return http.get(`/typeCompte?title=${title}`);
    }
}

export default new TypeCompteService();
