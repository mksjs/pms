package pms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ParkingLot {
	// total size of parkingLot
	int size;
	//VehicleType i.e CAR
	VehicleType VehicleType;
	// all active parking tickets, identified by their ticketNumber
	private HashMap<Integer, ParkingTicket> parkingSlot=null;
	private Queue<Integer> freeSlot = null;
	int countOfFreeSlots;
	int countOfocupiedSlot;

	public ParkingLot(int size) {
		this.size = size;
		parkingSlot = new HashMap<Integer, ParkingTicket>();
		freeSlot = new LinkedList<Integer>();
		for(int i=1;i<size;i++) {
			freeSlot.add(i);
		}
	}

	ParkingTicket getNewParkingTicket(Vehicle vehicle) throws ParkingFullException {
		if (this.isFull(vehicle.getType())) {
			throw new ParkingFullException();
		}
		ParkingTicket ticket = new ParkingTicket();
		int slotNumber = this.getFreeSlot();
		ticket.setTicketNumber(slotNumber+"random String");
		ticket.setSlotNumber(slotNumber);
		ticket.setVehicleId(vehicle.getVehicleId());
		vehicle.setTicket(ticket);
		ticket.saveInDB();
		this.updateSlot(vehicle.getType());
		this.parkingSlot.put(slotNumber, ticket);
		return ticket;
	}

	private void updateSlot(VehicleType type) {
		// TODO Auto-generated method stub
		if(type.equals(VehicleType.CAR)) {
			this.countOfFreeSlots--;
			this.countOfocupiedSlot++;
		}
	}


	private boolean isFull(VehicleType type) {
		// TODO Auto-generated method stub
		if(type.equals(VehicleType.CAR)) {
			if(countOfFreeSlots == 0 || countOfocupiedSlot == this.size) {
				return true;
			}
		}
		return false;
	}
	
	int getFreeSlot() throws ParkingFullException {
		if(this.freeSlot.size() == 0) {
			throw new ParkingFullException();
		}
		return this.freeSlot.poll();
	}
	Boolean checkoutFromParkingLot(ParkingTicket ticket) throws ParkingVehicleNotFoundException {
		int slotNumber = ticket.getSlotNumber();
		if(!this.parkingSlot.containsKey(slotNumber)) {
			throw new ParkingVehicleNotFoundException();
		}
		
		this.parkingSlot.remove(slotNumber);
		this.countOfFreeSlots++;
		this.countOfocupiedSlot--;
		return this.freeSlot.offer(slotNumber);
	}
}
