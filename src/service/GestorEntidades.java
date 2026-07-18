package service;

import model.Chofer;
import model.GuiaTuristico;
import model.ProveedorHospedaje;
import model.Registrable;

import java.util.ArrayList;
import java.util.List;

public class GestorEntidades {
    private final List<Registrable> listaRegistrables;

    public GestorEntidades(List<Registrable> listaRegistrables) {
        this.listaRegistrables = listaRegistrables;
    }

    public List<Registrable> buscarChoferPorLicencia(String tipoLicenciaBuscada) {
        List<Registrable> choferesEncontrados = new ArrayList<>();

        for (Registrable r : listaRegistrables) {
            if (r instanceof Chofer chofer) {
                if (chofer.getTipoLicencia().equalsIgnoreCase(tipoLicenciaBuscada)) {
                    choferesEncontrados.add(chofer);
                }
            }
        }

        return choferesEncontrados;
    }

    public List<Registrable> buscarGuiaPorIdioma(String idiomaBuscado) {
        List<Registrable> guiasEncontrados = new ArrayList<>();

        for (Registrable r : listaRegistrables) {
            if (r instanceof GuiaTuristico guia) {
                for (String idioma : guia.getIdiomas()) {
                    if (idioma.equalsIgnoreCase(idiomaBuscado)) {
                        guiasEncontrados.add(guia);
                        break;
                    }
                }
            }
        }

        return guiasEncontrados;
    }

    public List<Registrable> buscarHospedajePorTipo(String hospedajeBuscado) {
        List<Registrable> proveedoresEncontrados = new ArrayList<>();

        for (Registrable r : listaRegistrables) {
            if (r instanceof ProveedorHospedaje hospedaje) {
                if (hospedaje.getTipoHospedaje().equalsIgnoreCase(hospedajeBuscado)) {
                    proveedoresEncontrados.add(hospedaje);
                }
            }
        }

        return proveedoresEncontrados;
    }
}
