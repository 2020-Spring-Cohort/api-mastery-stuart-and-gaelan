import{
    DomMaker
} from './DomMaker.js'
import{
    InputMaker
} from './InputMaker.js'
import{getAllCountries} from './countryBuilder.js'

const createNewCountryForm= ()=>{
    const form = new DomMaker('form')
                .changeContent('Add new Country')
                .appendChild(new DomMaker('p')
                                .changeContent("Name:")
                                .render())
                .appendChild(new InputMaker()
                                .changeInputType('text')
                                .addClassName('form__name')
                                .addPlaceholder('New country name')
                                .render())
                .appendChild(new DomMaker('button')
                                .changeContent('Submit New Country')
                                .addOnClickAction(()=>{
                                    collectData();
                                })
                                .render())
                .render();
    return form;
}

const collectData = () =>{
    const newName = document.querySelector(".form__name");

    const newCountryJson = {
        "name": newName.value,
    }
    fetch("http://localhost:8080/countries/", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(newCountryJson)
    }).then(()=> getAllCountries());
}

export{createNewCountryForm}