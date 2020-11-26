class TareaDoingView{

    constructor(tareas) {
        this.tareas = tareas;
        this.onDeleteFinish = null;
    }

    delete = () =>{
        let xhr = new XMLHttpRequest();
        xhr.addEventListener('readystatechange',()=>{
            if(xhr.readyState === 4){
                var response = JSON.parse(xhr.responseText);
                if(this.onDeleteFinish != null) this.onDeleteFinish();
            }
        });
        xhr.open('DELETE', 'http://localhost:8080/Organizador/api/tareas/delete/'+this.tareas.id);
        xhr.send();
    }

    adv = () =>{
        let obj = {
            id: this.tareas.id,
            descripcion: this.tareas.descripcion,
            to_do: 0,
            doing: 0,
            done: 1,
            fecha: this.tareas.fecha
        };
        let xhr = new XMLHttpRequest();
        xhr.addEventListener('readystatechange',()=> {
            if (xhr.readyState === 4){
                var response = JSON.parse(xhr.responseText);
                this.actualizar();
            }
        });
        xhr.open('PUT', 'http://localhost:8080/Organizador/api/tareas/edit');
        xhr.setRequestHeader('Content-Type','application/json');
        xhr.send(JSON.stringify(obj));
    }

    back = () =>{
        let obj = {
            id: this.tareas.id,
            descripcion: this.tareas.descripcion,
            to_do: 1,
            doing: 0,
            done: 0,
            fecha: this.tareas.fecha
        };
        let xhr = new XMLHttpRequest();
        xhr.addEventListener('readystatechange',()=> {
            if (xhr.readyState === 4){
                var response = JSON.parse(xhr.responseText);
                this.actualizar();
            }
        });
        xhr.open('PUT', 'http://localhost:8080/Organizador/api/tareas/edit');
        xhr.setRequestHeader('Content-Type','application/json');
        xhr.send(JSON.stringify(obj));
    }

    render = () =>{
        let component = document.createElement('div');
        component.className = "TareaComponent";
        component.id = 'tarea'+this.tareas.id;
        let descripcion = document.createElement('p');
        descripcion.innerHTML = this.tareas.descripcion;
        let fecha = document.createElement('small');
        fecha.innerHTML = this.tareas.fecha;
        let delbtn = document.createElement('button');
        delbtn.className = "delt";
        let advbtn = document.createElement('button');
        advbtn.className = "adv";
        let backbtn = document.createElement('button');
        backbtn.className = "back";
        delbtn.addEventListener('click', this.delete);
        advbtn.addEventListener('click',this.adv);
        backbtn.addEventListener('click',this.back);
        component.appendChild(descripcion);
        component.appendChild(delbtn);
        component.appendChild(advbtn);
        component.appendChild(backbtn);
        component.appendChild(fecha);
        return component;

    };


};