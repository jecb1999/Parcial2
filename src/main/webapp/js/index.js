const tarea = document.getElementById('Tarea');
const SeccionesGeneral = document.getElementById('SeccionesGeneral');
const regTarea = document.getElementById('regTarea');

const registrar = ()=>{
    let date = new Date();
    let day = String(date.getDate()).padStart(2, '0');
    let month = (date.getMonth() + 1);
    let year = date.getFullYear();
    let tareaObj = {
        id:0,
        descripcion: tarea.value,
        to_do: 1,
        doing: 0,
        done: 0,
        fecha: day+"/"+month+"/"+year
    };

    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange',()=>{
        if(xhr.readyState === 4){
            SeccionesGeneral.innerHTML = '';
            getTareasToDo();
            getTareasDoing();
            getTareasDone();
        }
        tarea.value='';
    });
    xhr.open('POST', 'http://localhost:8080/Organizador/api/tareas/create');
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify(tareaObj));
}

const getTareasToDo=()=>{
    let component = document.createElement('div');
    component.innerHTML = '';
    component.className = 'tareaConteiner';
    component.id = 'to_do';
    let titulo = document.createElement('p');
    titulo.innerHTML = 'TO-DO';
    let body = document.createElement('body');
    component.appendChild(titulo);
    component.appendChild(body);
    SeccionesGeneral.appendChild(component);
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange',()=>{
        if(xhr.readyState === 4){
            let json = xhr.responseText;
            let response = JSON.parse(json);
            body.innerHTML='';
            for(let i =0;i<response.length;i++){
                console.log(response[i].descripcion);
                let tareaDTO = response[i];
                let view = new TareasToDoView(tareaDTO);
                view.onDeleteFinish =()=>{
                    body.removeChild(document.getElementById('tarea'+tareaDTO.id))
                }
                view.actualizar = () =>{
                    SeccionesGeneral.innerHTML = '';
                    getTareasToDo();
                    getTareasDoing();
                    getTareasDone();
                }
                body.appendChild(view.render())
            };


        }
    });
    xhr.open('GET','http://localhost:8080/Organizador/api/tareas/allToDo');
    xhr.send();

};

const getTareasDoing=()=>{
    let component = document.createElement('div');
    component.className = 'tareaConteiner';
    component.id = 'doing';
    let titulo = document.createElement('p');
    titulo.innerHTML = 'DOING';
    let body = document.createElement('body');
    component.appendChild(titulo);
    component.appendChild(body);
    SeccionesGeneral.appendChild(component);
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange',()=>{
        if(xhr.readyState === 4){
            let json = xhr.responseText;
            let response = JSON.parse(json);
            body.innerHTML='';
            for(let i =0;i<response.length;i++){
                console.log(response[i].descripcion);
                let tareaDTO = response[i];
                let view = new TareaDoingView(tareaDTO);
                view.onDeleteFinish =()=>{
                    body.removeChild(document.getElementById('tarea'+tareaDTO.id))
                }
                view.actualizar = () =>{
                    SeccionesGeneral.innerHTML = '';
                    getTareasToDo();
                    getTareasDoing();
                    getTareasDone();
                }
                body.appendChild(view.render())
            };


        }
    });
    xhr.open('GET','http://localhost:8080/Organizador/api/tareas/allToDoing');
    xhr.send();

};

const getTareasDone=()=>{
    let component = document.createElement('div');
    component.className = 'tareaConteiner';
    component.className = 'done';
    component.id = 'done';
    let titulo = document.createElement('p');
    titulo.innerHTML = 'DONE';
    let body = document.createElement('body');
    component.appendChild(titulo);
    component.appendChild(body);
    SeccionesGeneral.appendChild(component);
    let xhr = new XMLHttpRequest();
    xhr.addEventListener('readystatechange',()=>{
        if(xhr.readyState === 4){
            let json = xhr.responseText;
            let response = JSON.parse(json);
            body.innerHTML='';
            for(let i =0;i<response.length;i++){
                console.log(response[i].descripcion);
                let tareaDTO = response[i];
                let view = new TareaDoneView(tareaDTO);
                view.onDeleteFinish =()=>{
                    body.removeChild(document.getElementById('tarea'+tareaDTO.id))
                }
                view.actualizar = () =>{
                    SeccionesGeneral.innerHTML = '';
                    getTareasToDo();
                    getTareasDoing();
                    getTareasDone();
                }
                body.appendChild(view.render())
            };


        }
    });
    xhr.open('GET','http://localhost:8080/Organizador/api/tareas/allToDone');
    xhr.send();

};

regTarea.addEventListener('click', registrar);

getTareasToDo();
getTareasDoing();
getTareasDone();
