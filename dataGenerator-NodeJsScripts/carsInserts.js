fs = require('fs');
const axios = require('axios');
let cars = []

axios.get('https://vpic.nhtsa.dot.gov/api/vehicles/GetAllManufacturers?format=json')
  .then(function (response) {
    let i = 0
    response.data.Results.forEach((res, j) => {


      let mfrName = res.Mfr_CommonName
      if (mfrName != null || mfrName != undefined) {

        mfrName = mfrName.replace(" ", "_");
        axios.get('https://vpic.nhtsa.dot.gov/api/vehicles/GetModelsForMake/' + mfrName + '?format=json')
          .then(function (r) {
            if (r.data.Results[0] != undefined) {
              i++
              const car = {
                id: i,
                matricule: Math.random().toString(36).substr(2, 9),
                marque: mfrName,
                model: r.data.Results[0].Model_Name,
                kil: Math.floor(Math.random() * 50000),
                auto: (Math.random() < 0.5),
                clim: (Math.random() < 0.5),
                type: "gasol",
                catEco: 1
              }
              cars[i] = car
              console.log(j)
              if (j == 72) {
                hydrateTxt(cars)
              }
            }
          }).catch(function (error) {
            // handle error
            // console.log(error);
          })
      }

    });

  })


function hydrateTxt(cars) {
  let str = "INSERT INTO vehicule(id_vehicule, matricule, marque, modele, kilometrage, automatique, climatisation, type_carburant, id_categorie_economique) VALUES \n"
  cars.forEach(car => {
    str += `(${car.id},'${car.matricule}','${car.marque}','${car.model}',${car.kil},${car.auto},${car.clim},'${car.type}',${car.catEco}),\n`
  });
  fs.writeFile('cars.txt', str, function (err) {
    if (err) return console.log(err);
  });
}



// INSERT INTO vehicule(id_vehicule, matricule, marque, modele, kilometrage, automatique, climatisation, type_carburant, id_devis, id_client, id_categorie_economique)
// VALUES(1, 1, 'zde', 'ZA', 123, true, true, 'YUfez', null, null)
