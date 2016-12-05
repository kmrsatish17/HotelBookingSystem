package com.ssdi.project.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import com.ssdi.project.access.db.UserProfileDao;
import com.ssdi.project.access.db.UserProfileDaoImpl;
import com.ssdi.project.beans.RoomBookingDetails;
import com.ssdi.project.beans.RoomSearchDetail;
import com.ssdi.project.beans.RoomSearchSelectDetails;

public class PerformBusinessOperation {

	public RoomBookingDetails getModificationDetails(RoomSearchDetail modifiedRoomDetails,
			RoomBookingDetails oldRoomDetails) {

		double newbasicPrice = 0;
		double newGuestPrice = 0;
		double newTaxAmount = 0;
		double newTotalPrice = 0;
		double netPrice = 0;
		double modbasicPrice = 0;
		double modGuestPrice = 0;
		double modTaxAmount = 0;

		/*
		 * newbasicPrice = calculateBasePrice(modifiedRoomDetails.getFromDate(),
		 * modifiedRoomDetails.getToDate(), modifiedRoomDetails.getNoOfRooms(),
		 * modifiedRoomDetails.getRoomType(), newbasicPrice);
		 * 
		 * newGuestPrice = calculateExtraFee(modifiedRoomDetails.getNoOfRooms(),
		 * modifiedRoomDetails.getNoOfAdults());
		 * 
		 * modbasicPrice = (newbasicPrice) - (oldRoomDetails.getBasicPrice());
		 * modGuestPrice = (newGuestPrice) -
		 * (oldRoomDetails.getExtraGuestFee()); newTaxAmount = (newbasicPrice +
		 * newGuestPrice) * 0.15; newTotalPrice = (newbasicPrice + newGuestPrice
		 * + newTaxAmount);
		 * 
		 * oldRoomDetails.setFromDate(modifiedRoomDetails.getFromDate());
		 * oldRoomDetails.setToDate(modifiedRoomDetails.getToDate());
		 * oldRoomDetails.setRoomType(modifiedRoomDetails.getRoomType());
		 * oldRoomDetails.setNoOfRooms(modifiedRoomDetails.getNoOfRooms());
		 * oldRoomDetails.setNoOfAdults(modifiedRoomDetails.getNoOfAdults());
		 * oldRoomDetails.setBasicPrice(newbasicPrice);
		 * oldRoomDetails.setExtraGuestFee(newGuestPrice);
		 * oldRoomDetails.setTaxAmount(newTaxAmount);
		 * oldRoomDetails.setTotalPrice(newTotalPrice);
		 */

		return oldRoomDetails;
	}

	public double calculateBreakfastCharge(String fromDateStr, String toDateStr, String breakfastChecked) {

		double breakfastCostPerDay = 100;
		double breakfastCost = 0;

		long numberOfDays = getNumberOfDays(fromDateStr, toDateStr);

		if (breakfastChecked != null && !(breakfastChecked.isEmpty()) && "breakfast".equals(breakfastChecked)) {

			breakfastCost = numberOfDays * breakfastCostPerDay;
		}

		return breakfastCost;
	}

	public double calculateCabeCharge(String fromDateStr, String toDateStr, String cabeChecked) {

		double cabeCostPerDay = 1000;
		double cabeCost = 0;

		long numberOfDays = getNumberOfDays(fromDateStr, toDateStr);

		if (cabeChecked != null && !(cabeChecked.isEmpty()) && "cabe".equals(cabeChecked)) {

			cabeCost = numberOfDays * cabeCostPerDay;
		}

		return cabeCost;
	}

	public double calculateParkingCharge(String fromDateStr, String toDateStr, String parkingChecked) {

		double parkingCostPerDay = 300;
		double parkingCost = 0;

		long numberOfDays = getNumberOfDays(fromDateStr, toDateStr);

		if (parkingChecked != null && !(parkingChecked.isEmpty()) && "parking".equals(parkingChecked)) {

			parkingCost = numberOfDays * parkingCostPerDay;
		}

		return parkingCost;
	}

	public double calculateBasePrice(String fromDateStr, String toDateStr, int noOfRoomSelected, String roomTypeName,
			double basicPrice, String breakfastChecked, String parkingChecked, String cabeChecked) {

		double roomPricePerDayDel;
		double roomPricePerDaySupDel;
		double roomPricePerDayLux;
		String DELUXE = "deluxe";
		String SUP_DELUXE = "super deluxe";
		String LUXURY = "luxury";

		UserProfileDao userDao = new UserProfileDaoImpl();

		long numberOfDays = getNumberOfDays(fromDateStr, toDateStr);

		System.out.println("@@@@ numberOfDays " + numberOfDays);

		if (roomTypeName.equals(DELUXE)) {

			roomPricePerDayDel = userDao.getRoomPricePerDay(DELUXE, false);

			basicPrice = roomPricePerDayDel * (noOfRoomSelected) * numberOfDays;
		} else if (roomTypeName.equals(LUXURY)) {

			roomPricePerDayLux = userDao.getRoomPricePerDay(LUXURY, false);

			basicPrice = roomPricePerDayLux * (noOfRoomSelected) * numberOfDays;
		} else if (roomTypeName.equals(SUP_DELUXE)) {

			roomPricePerDaySupDel = userDao.getRoomPricePerDay(SUP_DELUXE, false);

			basicPrice = roomPricePerDaySupDel * (noOfRoomSelected) * numberOfDays;
		}

		return basicPrice;
	}

	private long getNumberOfDays(String fromDateStr, String toDateStr) {
		Date fromDate = null;
		Date toDate = null;

		// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

		try {

			fromDate = (Date) formatter.parse(fromDateStr);
			toDate = (Date) formatter.parse(toDateStr);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		long numberOfDays = ChronoUnit.DAYS.between(fromDate.toInstant(), toDate.toInstant()) + 1;
		return numberOfDays;
	}

	public double calculateExtraFee(int noOfRoomInt, int noOfAdultsInt) {
		// TODO Auto-generated method stub

		double extraGuestCharge = 500;

		if (noOfAdultsInt > (2 * noOfRoomInt)) {

			return extraGuestCharge * (noOfAdultsInt - (2 * noOfRoomInt));
		}

		return 0;
	}

	public boolean validateModification(String newRoomType, List<RoomSearchDetail> roomSearchList, int newNoOfRooms) {

		if (roomSearchList != null && !(roomSearchList.size() == 0)) {

			for (RoomSearchDetail room : roomSearchList) {

				if ((room.getNoOfRooms() >= newNoOfRooms) && (room.getRoomType().equals(newRoomType))) {

					return true;
				}
			}

		}

		return false;
	}

}
