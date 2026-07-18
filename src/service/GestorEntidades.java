package service;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class GestorEntidades {
    private final List<Registrable> listaRegistrables;

    public GestorEntidades(List<Registrable> listaRegistrables) {
        this.listaRegistrables = listaRegistrables;
    }

    public void agregarRegistrable(Registrable registrable) {
        if (registrable != null) {
            this.listaRegistrables.add(registrable);
        }
    }

    public String mostrarRegistrables() {
        StringBuilder sb = new StringBuilder();

        for (Registrable r : listaRegistrables) {
            if (r instanceof GuiaTuristico guia) {
                sb.append("- Guía -\n");
            } else if (r instanceof Chofer chofer) {
                sb.append("- Chofer -\n");
            } else if (r instanceof ProveedorHospedaje hospedaje) {
                sb.append("- Hospedaje -\n");
            } else {
                sb.append("- Vehículo -\n");
            }

            sb.append(r.mostrarDatos()).append("\n");
        }

        return sb.toString();
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

    public List<Registrable> buscarVehiculoPorTipo(String vehiculoBuscado) {
        List<Registrable> vehiculosEncontrados = new ArrayList<>();

        for (Registrable r : listaRegistrables) {
            if (r instanceof Vehiculo vehiculo) {
                if (vehiculo.getTipoVehiculo().equalsIgnoreCase(vehiculoBuscado)) {
                    vehiculosEncontrados.add((vehiculo));
                }
            }
        }

        return vehiculosEncontrados;
    }
}
