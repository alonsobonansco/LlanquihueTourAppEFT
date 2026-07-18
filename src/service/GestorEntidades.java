package service;

import model.*;

import java.util.ArrayList;
import java.util.Comparator;
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

        List<Registrable> listaOrdenada = listaRegistrables.stream()
                .sorted(Comparator.comparing(r -> {
                    if (r instanceof GuiaTuristico) return 1;
                    if (r instanceof Chofer) return 2;
                    if (r instanceof ProveedorHospedaje) return 3;
                    return 4;
                })).toList();

        String ultimoTipo = "";

        for (Registrable r : listaOrdenada) {
            String tipoActual = "";

            if (r instanceof GuiaTuristico) {
                tipoActual = "- Guías -";
            } else if (r instanceof Chofer) {
                tipoActual = "- Choferes -";
            } else if (r instanceof ProveedorHospedaje) {
                tipoActual = "- Hospedajes -";
            } else {
                tipoActual = "- Vehículos -";
            }

            if (!tipoActual.equals(ultimoTipo)) {
                sb.append("\n").append(tipoActual).append("\n");
                ultimoTipo = tipoActual;
            }

            sb.append(r.mostrarDatos());
        }

        return sb.toString();
    }

    public boolean eliminarRegistro(String registroAEliminar) {
        return listaRegistrables.removeIf(r -> switch (r) {
            case Vehiculo v -> v.getPatente().equalsIgnoreCase(registroAEliminar);
            case Chofer c -> c.getRut().equalsIgnoreCase(registroAEliminar);
            case GuiaTuristico g -> g.getRut().equalsIgnoreCase(registroAEliminar);
            case ProveedorHospedaje h -> h.getRut().equalsIgnoreCase(registroAEliminar);
            default -> false;
        });
    }

    public List<Registrable> getListaRegistrables() {
        return this.listaRegistrables;
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
