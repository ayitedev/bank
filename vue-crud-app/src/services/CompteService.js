import http from "../http-common";

class CompteService {
  getAll() {
    return http.get("/compte/");
  }

  get(id) {
    return http.get(`/compte/${id}`);
  }

  create(data) {
    return http.post("/compte/", data);
  }

  update(id, data) {
    return http.put(`/compte/${id}`, data);
  }

  delete(id) {
    return http.delete(`/compte/${id}`);
  }

  deleteAll() {
    return http.delete(`/compte`);
  }

  findByTitle(title) {
    return http.get(`/compte?title=${title}`);
  }
}

export default new CompteService();
