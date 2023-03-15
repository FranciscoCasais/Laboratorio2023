#include <iostream>
#include <vector>
using namespace std;
// a.
struct musico {
    string apellido,instrumento,nombre;
};
struct banda {
    musico m1,m2,m3,m4;
    string nombre;
};
// b.
bool bandaTieneEspacio(banda b) {
    if(b.m1.apellido=="" || b.m2.apellido=="" || b.m3.apellido=="" || b.m4.apellido=="") {
        return true;
    } else {
        return false;
    }
}
bool comprobarInstrumentos(banda b,musico m) {
    if(b.m1.instrumento==m.instrumento || b.m2.instrumento==m.instrumento || b.m3.instrumento==m.instrumento || b.m4.instrumento==m.instrumento) {
        return false;
    } else {
        return true;
    }
}
// c.
bool agregarMusico(banda &b) {
    musico nuevo;
    cout<<"Ingresar datos del músico:\nApellido: ";
    cin>>nuevo.apellido;
    cout<<"Nombre: ";
    cin>>nuevo.nombre;
    cout<<"Instrumento: ";
    cin>>nuevo.instrumento;
    if(bandaTieneEspacio(b)) {
        if(comprobarInstrumentos(b,nuevo)) {
            if(b.m1.apellido=="") {
                b.m1=nuevo;
            } if(b.m2.apellido=="") {
                b.m2=nuevo;
            } else if(b.m3.apellido=="") {
                b.m3=nuevo;
            } else {
                b.m4=nuevo;
            }
            cout<<"El músico fue agregado a la banda.";
            return true;
        } else {
            cout<<"Error: la banda ya tiene un músico que toca el mismo instrumento.";
        }
    } else {
        cout<<"Error: la banda solicitada está llena.";
    }
    return false;
}
void mostrarMusicos(vector<banda> bandas) {
    if(bandas.size()==0) {
        cout<<"No hay bandas registradas en el sistema.";
    } else {
        for(int i=0;i<bandas.size();i++) {
            cout<<"\nNombre de la banda: "<<bandas[i].nombre<<"\nIntegrantes:\n";
            for(int j=0;j<4;j++) {
                switch(j) {
                    case 0:
                    if(bandas[i].m1.apellido!="") {
                        cout<<bandas[i].m1.apellido<<", "<<bandas[i].m1.nombre<<"\n";
                    }
                    break;
                    case 1:
                    if(bandas[i].m2.apellido!="") {
                        cout<<bandas[i].m2.apellido<<", "<<bandas[i].m2.nombre<<"\n";
                    }
                    break;
                    case 2:
                    if(bandas[i].m3.apellido!="") {
                        cout<<bandas[i].m3.apellido<<", "<<bandas[i].m3.nombre<<"\n";
                    }
                    break;
                    case 3:
                    if(bandas[i].m4.apellido!="") {
                        cout<<bandas[i].m4.apellido<<", "<<bandas[i].m4.nombre<<"\n";
                    }
                    break;
                }
            }
        }
    }
}