fs = require('fs');
const axios = require('axios');
let personnes = []
let clients = []
let emps = []
axios.get('https://randomuser.me/api/?results=30&nat=fr')
  .then(function (response) {
    const datas = response.data.results
    datas.forEach((data, i) => {
      const per = {
        id: i,
        nom: data.name.last,
        prenom: data.name.first,
        email: data.email,
        telephone: data.cell,
        rue: data.location.street.number + "_" + data.location.street.name,
        ville: data.location.city,
        code: data.location.postcode,
      }

      if (Math.random() <= .3) {
        if (emps.length == 0) {
          type = "gerant"
        } else {
          type = "chauffeur"
        }
        const emp = {
          id: per.id,
          login: data.login.username,
          mdp: data.login.password,
          type: type
        }
        emps.push(emp)
      } else {
        const client = {
          id: per.id,
          cId: clients.length
        }
        clients.push(client)
      }
      per.rue = per.rue.replace("'", "-")
      per.telephone = per.telephone.replace(/-+/g, "")
      // pers.telephone = parseInt(pers.telephone)
      personnes.push(per)
    });
    hydrateTxt(personnes, clients, emps)
  })


function hydrateTxt(pers, clients, emps) {
  let str = "INSERT INTO personne(id_personne, nom, prenom, email, telephone, rue, ville, code_postal) VALUES \n"
  pers.forEach((per, i) => {
    str += `(${per.id},'${per.nom}','${per.prenom}','${per.email}',${per.telephone},'${per.rue}','${per.ville}','${per.code}')`
    if (i == pers.length - 1) {
      str += ";"
    } else {
      str += ",\n"
    }
  });
  fs.writeFile('personnes.txt', str, function (err) {
    if (err) return console.log(err);
  });

  str = "INSERT INTO client(id_client, id_personne) VALUES \n"
  clients.forEach((client, i) => {
    str += `(${client.id},${client.cId})`
    if (i == clients.length - 1) {
      str += ";"
    } else {
      str += ",\n"
    }
  });
  fs.writeFile('clients.txt', str, function (err) {
    if (err) return console.log(err);
  });

  str = "INSERT INTO employe(id_personne, login, mdp, type) VALUES \n"
  emps.forEach((emp, i) => {
    str += `(${emp.id},'${emp.login}','${emp.mdp}','${emp.type}')`
    if (i == emps.length - 1) {
      str += ";"
    } else {
      str += ",\n"
    }
  });
  fs.writeFile('employes.txt', str, function (err) {
    if (err) return console.log(err);
  });
}